package main.core;

import main.constants.Constants;

public class CompareNum implements Constants {
	RecordBoard record;

	public CompareNum(RecordBoard record) {
		this.record = record;
	}

	public String compareComAndUser(RandomNum comNum, RandomNum userNum) {
		record.setInitValue();

		if (comNum.toString().equals(userNum.toString())) {
			return HIT;
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
		int strikeCount = record.getStrikeCount();
		int ballCount = record.getBallCount();

		if (strikeCount == 0 && ballCount == 0) {
			return OUT;
		}

		String strikeStr = strikeCount <= 1 ? BALNK + STRIKE + BALNK : BALNK + STRIKES + BALNK;
		String ballStr = ballCount <= 1 ? BALNK + BALL : BALNK + BALLS;

		record.setGameCount(1);

		return strikeCount + strikeStr + ballCount + ballStr;
	}

}
