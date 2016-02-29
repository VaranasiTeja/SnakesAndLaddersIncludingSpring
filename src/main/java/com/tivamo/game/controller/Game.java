package com.tivamo.game.controller;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.board.Board;
import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.player.Player;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;

public class Game {

	public String newGame() {
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= GameProperties.NUM_PLAYERS; player++) {
			players.add(new Player(player));
		}
		Board board = new Board();
		this.createBoardByLevel(board);
		return this.playGame(players, board);
	}

	private String playGame(List<Player> players, Board board) {
		String result = null;
		List<Ladder> ladderList = board.getLadderList();
		List<Snake> snakeList = board.getSnakeList();
		boolean hasGameEnded = false;
		do {
			for (Player player : players) {
				int diceOutcome = RandomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
				int playerUpdatedPosition = LadderUtilities.getLadderTopPosition((player.getPosition() + diceOutcome),
						ladderList);
				player.setPosition(playerUpdatedPosition > GameProperties.NUM_POSITIONS_IN_BOARD ? player.getPosition()
						: playerUpdatedPosition);
				player.setPosition(SnakeUtilities.getSnakeTail(player.getPosition(), snakeList));
				if (player.getPosition() == GameProperties.NUM_POSITIONS_IN_BOARD) {
					hasGameEnded = true;
					result = "Player" + player.getPlayerId() + "  Won";
					break;
				}
			}
		} while (!hasGameEnded);
		return result;
	}

	private void createBoardByLevel(Board board) {
		Level level = new Level();
		level.createLaddersAndSnakesOnLevel("easy");
		board.generateValidBoard(level.getLadders(), level.getSnakes());
	}
}