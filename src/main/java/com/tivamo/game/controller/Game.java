package com.tivamo.game.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tivamo.game.board.Board;
import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.player.Player;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;

@Component
public class Game {

	@Autowired
	private GameProperties gameProperties;

	@Autowired
	private Level level;

	@Autowired
	private Board board;

	private String result;

	public String newGame(String levelValue) {
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= gameProperties.NUM_PLAYERS; player++) {
			players.add(new Player(player));
		}
		this.createBoardByLevel(board, levelValue);
		return this.playGame(players, board, levelValue);
	}

	private String playGame(List<Player> players, Board board, String levelValue) {
		List<Ladder> ladderList = board.getLadderList();
		List<Snake> snakeList = board.getSnakeList();
		boolean hasGameEnded = false;
		do {
			if (players.size() == 0) {
				hasGameEnded = true;
				return "Minimum Number of players Should be 1";
			}
			for (Player player : players) {
				int diceOutcome = RandomNumber.diceOutcome(gameProperties.DICE_OUTCOME_RANGE);
				int playerUpdatedPosition = LadderUtilities.getLadderTopPosition((player.getPosition() + diceOutcome),
						ladderList);
				player.setPosition(playerUpdatedPosition > gameProperties.NUM_POSITIONS_IN_BOARD ? player.getPosition()
						: playerUpdatedPosition);
				player.setPosition(SnakeUtilities.getSnakeTail(player.getPosition(), snakeList));
				if (player.getPosition() == gameProperties.NUM_POSITIONS_IN_BOARD) {
					hasGameEnded = true;
					result = "Player " + player.getPlayerId() + "  Won" + " snakeSize = " +  board.getSnakeList().size() + " ladder size = " + board.getLadderList().size();
					break;
				}
			}
		} while (!hasGameEnded);
		return result;
	}

	private void createBoardByLevel(Board board, String levelValue) {
		board.generateValidBoard(level.getLadders(levelValue), level.getSnakes(levelValue));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}