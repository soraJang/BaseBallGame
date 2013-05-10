package main.core;

import main.constants.Constants;

public class CompareNum implements Constants {
	RecordBoard record = new RecordBoard();

	public int getGameCount() {
		return record.getGameCount();
	}

	public String compareComAndUser(RandomNum randomNum, RandomNum userNum) {
		record.setInitValue();

		if (randomNum.toString().equals(userNum.toString())) {
			return HIT;
		} else {
			return StrikeOrBall(randomNum.getNum(), userNum.getNum());
		}
	}

	private String StrikeOrBall(int[] randomNum, int[] userNum) {
		for (int i = 0, iSize = randomNum.length; i < iSize; i++) {
			if (randomNum[i] == userNum[i]) {
				record.setStrike(1);
			} else {
				for (int j = 0, jSize = userNum.length; j < jSize; j++) {
					if (randomNum[i] == userNum[j]) {
						record.setBall(1);
					}
				}
			}
		}
		return resultStr();
	}

	private String resultStr() {
		int strike = record.getStrike();
		int ball = record.getBall();

		if (strike == 0 && ball == 0) {
			return OUT;
		}

		String strikeStr = strike <= 1 ? BALNK + STRIKE + BALNK : BALNK + STRIKES + BALNK;
		String ballStr = ball <= 1 ? BALNK + BALL : BALNK + BALLS;

		record.setGameCount(1);

		return strike + strikeStr + ball + ballStr;
	}
}
