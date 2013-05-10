package main.core;

public class RecordBoard {
	private int ballCount;
	private int strikeCount;
	private int gameCount = 0;
	private int[] usedNum = { 0, 0, 0 };
	private int gameNo = 0;

	public void setInitValue() {
		this.ballCount = 0;
		this.strikeCount = 0;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount += ballCount;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(int strikeCount) {
		this.strikeCount += strikeCount;
	}

	public int getGameCount() {
		return gameCount;
	}

	public void setGameCount(int gameCount) {
		this.gameCount += gameCount;
	}

	public int[] getUsedNum() {
		return usedNum;
	}

	public void setUsedNum(int[] usedNum) {
		this.usedNum = usedNum;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo() {
		this.gameNo += 1;
	}
}
