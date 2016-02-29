package com.tivamo.game.player;

public class Player {

	private int playerId;

	public Player(int playerId) {
		this.playerId = playerId;
	}

	public int getPlayerId() {
		return this.playerId;
	}

	private int position = 0;

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

}
