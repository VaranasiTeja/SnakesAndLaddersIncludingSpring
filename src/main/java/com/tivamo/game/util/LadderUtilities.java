package com.tivamo.game.util;

import java.util.List;

import com.tivamo.game.ladder.Ladder;

public class LadderUtilities {

	public static int getLadderTopPosition(int bottomPosition, List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			if (ladder.getBottomPosition() == bottomPosition)
				return ladder.getTopPosition();
		}
		return bottomPosition;
	}

	public static boolean isValidLadder(Ladder newLadder, List<Ladder> ladderList) {
		for (Ladder ladder : ladderList) {
			if (ladder.getBottomPosition() == newLadder.getBottomPosition()
					|| ladder.getTopPosition() == newLadder.getBottomPosition()
					|| ladder.getTopPosition() == newLadder.getTopPosition()
					|| ladder.getBottomPosition() == newLadder.getTopPosition())
				return false;
		}
		return true;
	}

}
