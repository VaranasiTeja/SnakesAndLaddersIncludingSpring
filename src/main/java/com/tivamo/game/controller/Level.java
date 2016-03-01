package com.tivamo.game.controller;

import java.util.List;
import java.util.Map;

public class Level {

	private Map<String, List<Integer>> levelMap;

	public Level(Map<String, List<Integer>> levelMap) {
		this.levelMap = levelMap;
	}

	public int getLadders(String level) {
		List<Integer> l = levelMap.get(level);
		if (l == null) {
			throw new RuntimeException("wrong level value!");
		}
		return l.get(0);
	}

	public int getSnakes(String level) {
		List<Integer> l = levelMap.get(level);
		if (l == null) {
			throw new RuntimeException("wrong level value!");
		}
		return l.get(1);
	}

}
