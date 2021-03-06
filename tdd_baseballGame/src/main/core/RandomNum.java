package main.core;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import main.core.bean.RecordBoard;
import main.core.pattern.observer.Watcher;

public class RandomNum implements GameNums {
	RecordBoard record;

	private int[] randomNum = { 0, 0, 0 };

	public RandomNum(RecordBoard record) {
		this.record = record;
		this.randomNum = getRandoms();
		record.setUsedNum(randomNum);
		record.setGameNo();
	}

	public RandomNum(int[] num, RecordBoard record) {
		this.record = record;
		this.randomNum = num;
		record.setUsedNum(randomNum);
	}

	public int[] getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(int[] num) {
		this.randomNum = num;
	}

	private int getOneRandomNum() {
		int n = (int) (Math.random() * 10);
		if (n == 0) {
			return getOneRandomNum();
		}
		return n;
	}

	private int[] getRandoms() {
		boolean checker = false;
		for (int i = 0; i < 3; i++) {
			randomNum[i] = getOneRandomNum();
		}
		if (isSameThreeNumIsDiff(randomNum) || isSame(randomNum)) {
			checker = true;
		}

		return checker ? getRandoms() : randomNum;
	}

	@Override
	public String toString() {
		return Arrays.toString(randomNum);
	}

	public String converToString(int[] num) {
		return Arrays.toString(num);
	}

	private boolean isSameThreeNumIsDiff(int[] randomNum) {
		if (randomNum[0] == randomNum[1] || randomNum[1] == randomNum[2]
				|| randomNum[2] == randomNum[0]) {
			return true;
		}
		return false;
	}

	private boolean isSame(int[] createdNum) {
		String recordNum = converToString(record.getUsedNum());

		if (recordNum != null && recordNum.equals(converToString(createdNum))) {
			return true;
		} else {
			return false;
		}
	}
}
