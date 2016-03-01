package com.tivamo.game.ladder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tivamo.game.properties.GameProperties;
import com.tivamo.game.util.LadderUtilities;
import com.tivamo.game.util.RandomNumber;

@Component
public class LadderManager {

	@Autowired
	private GameProperties gameProperties;

	public List<Ladder> generateLadderList(int maxLadders) {
		List<Ladder> ladderList = new ArrayList<Ladder>();
		while (ladderList.size() < maxLadders) {
			int topPosition = RandomNumber.getRandomNumberInRange(gameProperties.NUM_POSITIONS_IN_BOARD - 1, 12);
			int bottomPosition = RandomNumber.getRandomNumberInRange(topPosition - 10, 2);
			Ladder newLadder = new Ladder(topPosition, bottomPosition);
			if (LadderUtilities.isValidLadder(newLadder, ladderList)) {
				ladderList.add(newLadder);
			}
		}
		return ladderList;
	}

}
