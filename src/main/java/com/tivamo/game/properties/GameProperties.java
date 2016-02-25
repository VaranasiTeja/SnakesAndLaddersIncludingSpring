package com.tivamo.game.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameProperties {
	public static int NUM_LADDERS_EASY;
	public static int NUM_SNAKES_EASY;
	public static int NUM_LADDERS_HARD;
	public static int NUM_SNAKES_HARD;
	public static int NUM_POSITIONS_IN_BOARD;
	public static int DICE_OUTCOME_RANGE;
	public static int NUM_PLAYERS;

	public static void read() throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream("/home/teja/Videos/eclipse/game/src/main/resources/global.properties");
		properties.load(input);
		NUM_LADDERS_EASY = Integer.parseInt(properties.getProperty("numLaddersEasy"));
		NUM_SNAKES_EASY = Integer.parseInt(properties.getProperty("numSnakesEasy"));
		NUM_LADDERS_HARD = Integer.parseInt(properties.getProperty("numLaddersHard"));
		NUM_SNAKES_HARD = Integer.parseInt(properties.getProperty("numSnakesHard"));
		NUM_POSITIONS_IN_BOARD = Integer.parseInt(properties.getProperty("numPositionsInBoard"));
		DICE_OUTCOME_RANGE = Integer.parseInt(properties.getProperty("diceOutcomeRange"));
		NUM_PLAYERS = Integer.parseInt(properties.getProperty("numPlayers"));

	}
}
