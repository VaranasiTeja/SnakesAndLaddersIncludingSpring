package com.tivamo.game.snake;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.RandomNumber;
import com.tivamo.game.util.SnakeUtilities;

@Component
public class SnakeManager {

	@Autowired
	private GameProperties gameProperties;

	public List<Snake> generateSnakeList(int maxSnakes) {
		List<Snake> snakeList = new ArrayList<Snake>();
		int head, tail;
		while (snakeList.size() < maxSnakes) {
			head = RandomNumber.getRandomNumberInRange(gameProperties.NUM_POSITIONS_IN_BOARD - 1, 12);
			tail = RandomNumber.getRandomNumberInRange(head - 10, 2);
			Snake newSnake = new Snake(head, tail);
			if (SnakeUtilities.isValidSnake(newSnake, snakeList)) {
				snakeList.add(newSnake);
			}
		}
		return snakeList;
	}
}
