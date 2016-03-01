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

	public String newGame() {
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= gameProperties.NUM_PLAYERS; player++) {
			players.add(new Player(player));
		}
		this.createBoardByLevel(board);
		return this.playGame(players, board);
	}

	private String playGame(List<Player> players, Board board) {
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
					result = "Player" + player.getPlayerId() + "  Won";
					break;
				}
			}
		} while (!hasGameEnded);
		return result;
	}

	private void createBoardByLevel(Board board) {
		level.createLaddersAndSnakesOnLevel("easy");
		board.generateValidBoard(level.getLadders(), level.getSnakes());
	}
}