package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.core.RandomNum;
import main.core.RecordBoard;

public class BaseballGame {
	static RandomNum random;

	private static void init() {
		random = new RandomNum(new RecordBoard());
	}

	private static void menu(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) throws IOException {
		init();

		System.out.println("please insert 3 num");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String keyword;

		do {
			keyword = bf.readLine();
			if (!keyword.equals("exit")) {
				menu(keyword);
			}
		} while (!keyword.equals("exit"));
	}

}
