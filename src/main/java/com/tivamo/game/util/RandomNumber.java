package com.tivamo.game.util;

import java.util.Random;

public class RandomNumber {
	private static Random r;

	static {
		r = new Random();
	}

	public static int diceOutcome(int max) {
		return r.nextInt(max) + 1;
	}

	public static int getRandomNumberInRange(int max, int min) {
		return r.nextInt((max - min) + 1) + min;
	}

}
