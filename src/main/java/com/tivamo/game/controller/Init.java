package com.tivamo.game.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Init {

	@RequestMapping(value = "/newgame", method = RequestMethod.GET)
	public String initGame() throws IOException {
		Game game = new Game();
		return game.newGame();
	}

}
