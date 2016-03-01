package com.tivamo.game.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tivamo.game.ladder.Ladder;
import com.tivamo.game.ladder.LadderManager;
import com.tivamo.game.snake.Snake;
import com.tivamo.game.snake.SnakeManager;

@Component
public class Board {

	private List<Ladder> ladderList;
	private List<Snake> snakeList;

	@Autowired
	private LadderManager ladderManager;

	@Autowired
	private SnakeManager snakeManager;

	public void generateValidBoard(int ladders, int snakes) {
		do {
			ladderList = ladderManager.generateLadderList(ladders);
			snakeList = snakeManager.generateSnakeList(snakes);
		} while (!isValidBoard(ladderList, snakeList));
	}

	public boolean isValidBoard(List<Ladder> ladderList, List<Snake> snakeList) {
		for (Ladder ladder : ladderList) {
			for (Snake snake : snakeList) {
				if (ladder.getTopPosition() == snake.getHeadPos() || ladder.getBottomPosition() == snake.getHeadPos()
						|| ladder.getTopPosition() == snake.getTailPos()
						|| ladder.getBottomPosition() == snake.getTailPos())
					return false;
			}
		}
		return true;
	}

	public List<Ladder> getLadderList() {
		return ladderList;
	}

	public List<Snake> getSnakeList() {
		return snakeList;
	}

}
