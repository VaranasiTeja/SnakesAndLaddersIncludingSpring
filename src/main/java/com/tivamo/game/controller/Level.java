package com.tivamo.game.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tivamo.game.properties.GameProperties;

@Component
public class Level {

	@Autowired
	private GameProperties gameProperties;

	@Autowired
	private HashMap<String, HashMap<Integer, Integer>> hashmap;

	private int ladders;
	private int snakes;

	public void createLaddersAndSnakesOnLevel(String level) {
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>();
		map2.put(gameProperties.NUM_LADDERS_EASY, gameProperties.NUM_SNAKES_EASY);
		hashmap.put("easy", map2);
		map3.put(gameProperties.NUM_LADDERS_HARD, gameProperties.NUM_SNAKES_HARD);
		hashmap.put("hard", map3);
		for (Map.Entry<Integer, Integer> key : hashmap.get(level).entrySet()) {
			ladders = key.getKey();
			snakes = key.getValue();
			System.out.println("Ladders In this Level: " + key.getKey());
			System.out.println("Snakes In this Level: " + key.getValue());
		}
	}

	public int getLadders() {
		return ladders;
	}

	public int getSnakes() {
		return snakes;
	}

}
