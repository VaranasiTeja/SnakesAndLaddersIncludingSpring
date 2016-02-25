package com.tivamo.game.snake;

public class Snake {

	private int headPos;
	private int tailPos;

	public Snake(int headPos, int tailPos) {
		this.headPos = headPos;
		this.tailPos = tailPos;
	}

	public int getHeadPos() {
		return this.headPos;
	}

	public int getTailPos() {
		return this.tailPos;
	}

}
