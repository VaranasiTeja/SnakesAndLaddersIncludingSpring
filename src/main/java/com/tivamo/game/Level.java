package com.tivamo.game;

import java.util.HashMap;
import java.util.Map;

import com.tivamo.game.properties.GameProperties;

public class Level {
	static int ladders;
	static int snakes;

	public void createLaddersAndSnakesOnLevel(String level) {
		HashMap<String, HashMap<Integer, Integer>> hashmap = new HashMap<String, HashMap<Integer, Integer>>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>();
		map2.put(GameProperties.NUM_LADDERS_EASY, GameProperties.NUM_SNAKES_EASY);
		hashmap.put("easy", map2);
		map3.put(GameProperties.NUM_LADDERS_HARD, GameProperties.NUM_SNAKES_HARD);
		hashmap.put("hard", map3);
		for (Map.Entry<Integer, Integer> key : hashmap.get(level).entrySet()) {
			ladders = key.getKey();
			snakes = key.getValue();
			System.out.println("Ladders In this Level: " + key.getKey());
			System.out.println("Snakes In this Level: " + key.getValue());
		}
	}
}
