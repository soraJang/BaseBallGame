package main.core;

import java.util.Arrays;

public class RandomNum {
	private RecordBoard record = new RecordBoard();

	private int[] num = { 0, 0, 0 };

	public RandomNum() {
		this.num = getRandoms();
	}

	public RandomNum(int[] num) {
		this.num = num;
	}

	public int[] getNum() {
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

	public RecordBoard getRecord() {
		return record;
	}

	public void setRecord(RecordBoard record) {
		this.record = record;
	}

	private int getRandom() {
		int n = (int) (Math.random() * 10);
		if (n == 0) {
			return getRandom();
		}
		return n;
	}

	private int[] getRandoms() {
		for (int i = 0; i < 3; i++) {
			num[i] = getRandom();
		}
		return num;
	}

	@Override
	public String toString() {
		return Arrays.toString(num);
	}
}
