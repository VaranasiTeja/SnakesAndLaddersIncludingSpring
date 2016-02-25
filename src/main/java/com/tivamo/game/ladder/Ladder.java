package com.tivamo.game.ladder;

public class Ladder {

	private int topPosition;
	private int bottomPosition;

	public Ladder(int topPosition, int bottomPosition) {
		this.topPosition = topPosition;
		this.bottomPosition = bottomPosition;
	}

	public int getTopPosition() {
		return this.topPosition;
	}

	public int getBottomPosition() {
		return this.bottomPosition;
	}

}