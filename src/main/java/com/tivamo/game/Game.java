package com.tivamo.game;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Game {

	@RequestMapping(value = "/newgame", method = RequestMethod.GET)
	public String playGame() throws IOException {
		Init playGame = new Init();
		return playGame.init();
	}
}
