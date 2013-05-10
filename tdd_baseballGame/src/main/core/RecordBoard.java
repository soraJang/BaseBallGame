package main.core;

public class RecordBoard {
	private int ball;
	private int strike;
	private int gameCount = 0;

	public void setInitValue() {
		this.ball = 0;
		this.strike = 0;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball += ball;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike += strike;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount += gameCount;
	}
}
