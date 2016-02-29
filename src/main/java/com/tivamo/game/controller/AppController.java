package com.tivamo.game.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS })
	public String ping() {
		return "Welcome to Snakes And Ladders Game Home Page";
	}

}
