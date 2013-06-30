package main.core;

import java.util.Observable;
import java.util.Observer;

import main.constants.Constants;
import main.core.bean.RecordBoard;
import main.core.pattern.observer.Watcher;

public class CompareNum implements Constants, Observer{
	RecordBoard record;

	public CompareNum(RecordBoard record) {
		this.record = record;
	}

	public String compareComAndUser(RandomNum comNum, RandomNum userNum) {
		record.setInitValue();

		if (comNum.toString().equals(userNum.toString())) {
			return hitStr();
		} else {
			return StrikeOrBall(comNum.getRandomNum(), userNum.getRandomNum());
		}
	}

	private String StrikeOrBall(int[] comNum, int[] userNum) {
		for (int i = 0, iSize = comNum.length; i < iSize; i++) {
			if (comNum[i] == userNum[i]) {
				record.setStrikeCount(1);
			} else {
				for (int j = 0, jSize = userNum.length; j < jSize; j++) {
					if (comNum[i] == userNum[j]) {
						record.setBallCount(1);
					}
				}
			}
		}
		return resultStr();
	}

	private String resultStr() {
		if (record.getGameCount() < 10) {
			int strikeCount = record.getStrikeCount();
			int ballCount = record.getBallCount();
			if (strikeCount == 0 && ballCount == 0) {
				record.gameCountPlusOne(1);
				return outStr();
			}
			String strikeStr = strikeCount <= 1 ? BLANK + STRIKE + BLANK
					: BLANK + STRIKES + BLANK;
			String ballStr = ballCount <= 1 ? BLANK + BALL : BLANK + BALLS;
			record.gameCountPlusOne(1);
			return strikeCount + strikeStr + ballCount + ballStr;
		} else {
			record.setGameCount(0);
			return outStr();
		}
	}

	private String outStr() {
		return OUT;
	}

	private String hitStr() {
		record.setGameCount(0);
		return HIT;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Watcher) {
			System.out.println("watcher!");
		}
	}
}
