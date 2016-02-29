package com.tivamo.game;

import java.io.IOException;

import com.tivamo.game.properties.GameProperties;

public class Global {
	
	void init() throws IOException{
		GameProperties.read();
	}

}
