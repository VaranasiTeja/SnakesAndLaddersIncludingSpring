package com.tivamo.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Init {

	@Autowired
	private Game game;

	@RequestMapping(value = "/newgame", method = RequestMethod.GET)
	public String initGame() {
		return game.newGame();
	}

}
