package com.tivamo.game.util;

import java.util.List;

import com.tivamo.game.snake.Snake;

public class SnakeUtilities {

	public static int getSnakeTail(int headPosition, List<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getHeadPos() == headPosition)
				return snake.getTailPos();
		}
		return headPosition;
	}

	public static boolean isValidSnake(Snake newSnake, List<Snake> snakeList) {
		for (Snake snake : snakeList) {
			if (snake.getTailPos() == newSnake.getTailPos() || snake.getHeadPos() == newSnake.getTailPos()
					|| snake.getHeadPos() == newSnake.getHeadPos() || snake.getTailPos() == newSnake.getHeadPos())
				return false;
		}
		return true;
	}
}
