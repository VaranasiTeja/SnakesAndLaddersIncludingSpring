package com.tivamo.game.util;

import java.util.List;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.snake.Snake;

public class DisplayBoard {

	public void displayLadders(List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			System.out.println(ladder.getBottomPosition() + "  " + ladder.getTopPosition());
		}
	}

	public void displaySnakes(List<Snake> sankeList) {
		for (Snake snake : sankeList) {
			System.out.println(snake.getTailPos() + "  " + snake.getHeadPos());
		}
	}

}
