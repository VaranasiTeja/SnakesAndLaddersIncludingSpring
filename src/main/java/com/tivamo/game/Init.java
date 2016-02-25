package com.tivamo.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.board.Board;
import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;
import com.tivamo.game.player.Player;

public class Init {

	String result;

	public String init() throws IOException {
		GameProperties.read();
		List<Player> players = new ArrayList<Player>();
		for (int player = 1; player <= GameProperties.NUM_PLAYERS; player++) {
			players.add(new Player());
		}
		Board board = new Board();
		Init.createBoardByLevel(board);
		Init game = new Init();
		return game.playGame(players, board);

	}

	private String playGame(List<Player> players, Board board) {
		List<Ladder> ladderList = board.getLadderList();
		List<Snake> snakeList = board.getSnakeList();
		int diceOutcome, playerUpdatedPosition;
		boolean hasGameEnded = false;
		do {
			for (Player player : players) {
				diceOutcome = RandomNumber.diceOutcome(GameProperties.DICE_OUTCOME_RANGE);
				playerUpdatedPosition = LadderUtilities.getLadderTopPosition((player.getPosition() + diceOutcome),
						ladderList);
				player.setPosition(playerUpdatedPosition > GameProperties.NUM_POSITIONS_IN_BOARD ? player.getPosition()
						: playerUpdatedPosition);
				player.setPosition(SnakeUtilities.getSnakeTail(player.getPosition(), snakeList));
				if (player.getPosition() == GameProperties.NUM_POSITIONS_IN_BOARD) {
					// System.out.println(player.hashCode() + " wins");
					hasGameEnded = true;
					this.result = player.hashCode() + "  wins";
					break;
				}
			}
		} while (!hasGameEnded);
		System.out.println(result);
		return result;
	}

	private static void createBoardByLevel(Board board) throws IOException {
		System.out.println("Enter Level Of the Game easy/hard :");
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		String level = "easy";
		Level levelObj = new Level();
		levelObj.createLaddersAndSnakesOnLevel(level);
		board.generateValidBoard(Level.ladders, Level.snakes);
	}
}