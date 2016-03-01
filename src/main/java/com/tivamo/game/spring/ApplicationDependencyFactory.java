package com.tivamo.game.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.tivamo.game.controller.Level;
import com.tivamo.game.properties.GameProperties;

@Configuration
public class ApplicationDependencyFactory {

	@Autowired
	private GameProperties gameProperties;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Level getLevel() {
		Map<String, List<Integer>> levelMap = new HashMap<String, List<Integer>>();
		levelMap.put("easy",
				new ArrayList<Integer>(Arrays.asList(gameProperties.NUM_LADDERS_EASY, gameProperties.NUM_SNAKES_EASY)));
		levelMap.put("hard",
				new ArrayList<Integer>(Arrays.asList(gameProperties.NUM_LADDERS_HARD, gameProperties.NUM_SNAKES_HARD)));
		return new Level(levelMap);
	}

}
