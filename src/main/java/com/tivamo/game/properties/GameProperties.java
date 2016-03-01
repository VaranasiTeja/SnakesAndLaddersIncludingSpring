package com.tivamo.game.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class GameProperties {

	@Value("${numLaddersEasy}")
	public int NUM_LADDERS_EASY;

	@Value("${numSnakesEasy}")
	public int NUM_SNAKES_EASY;

	@Value("${numLaddersHard}")
	public int NUM_LADDERS_HARD;

	@Value("${numSnakesHard}")
	public int NUM_SNAKES_HARD;

	@Value("${numPositionsInBoard}")
	public int NUM_POSITIONS_IN_BOARD;

	@Value("${diceOutcomeRange}")
	public int DICE_OUTCOME_RANGE;

	@Value("${numPlayers}")
	public int NUM_PLAYERS;
}
