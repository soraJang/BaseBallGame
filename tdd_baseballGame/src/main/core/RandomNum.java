package main.core;

import java.util.Arrays;

public class RandomNum {
	RecordBoard record;

	private int[] randomNum = { 0, 0, 0 };

	public RandomNum(RecordBoard record) {
		this.record = record;
		this.randomNum = getRandoms();
		record.setUsedNum(randomNum);
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
		for (int i = 0; i < 3; i++) {
			randomNum[i] = getOneRandomNum();
		}
		return isSame(randomNum) ? getRandoms() : randomNum;
	}

	@Override
	public String toString() {
		return Arrays.toString(randomNum);
	}

	private String converToString(int[] num) {
		return Arrays.toString(num);
	}

	public boolean isSame(int[] createdNum) {
		String recordNum = converToString(record.getUsedNum());

		if (recordNum != null && recordNum.equals(converToString(createdNum))) {
			return true;
		} else {
			return false;
		}
	}
}
