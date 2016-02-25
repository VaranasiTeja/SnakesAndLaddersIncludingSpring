package com.tivamo.game.ladder;

import java.util.ArrayList;
import java.util.List;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;

public class LadderManager {

	public List<Ladder> generateLadderList(int maxLadders) {
		List<Ladder> ladderList = new ArrayList<Ladder>();
		while (ladderList.size() < maxLadders) {
			int topPosition = RandomNumber.getRandomNumberInRange(GameProperties.NUM_POSITIONS_IN_BOARD - 1, 12);
			int bottomPosition = RandomNumber.getRandomNumberInRange(topPosition - 10, 2);
			Ladder newLadder = new Ladder(topPosition, bottomPosition);
			if (LadderUtilities.isValidLadder(newLadder, ladderList)) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

}
