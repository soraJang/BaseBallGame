package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import main.constants.Constants;
import main.core.CompareNum;
import main.core.RandomNum;
import main.core.RecordBoard;

public class BaseballGame implements Constants {
	static RandomNum random;
	static RecordBoard record = new RecordBoard();
	static CompareNum check = new CompareNum(record);

	private static void init() {
		random = new RandomNum(record);
	}

	private static void menu(String insetMsg) throws IOException {
		String msg = insetMsg.toLowerCase();

		if (msg.equals(HELP)) {
			showHelpList();
		} else if (msg.equals(I)) {
			showGameInfo();
		} else if (msg.equals(R)) {
			resetGame();
		} else if (msg.equals(S)) {
			startGame();
		} else {
			System.out.println("도움을 원하시면 help를 입력해주세요");
		}
	}

	private static void showGameInfo() {
		System.out.println(record.toString());
	}

	private static void resetGame() {
	}

	private static BaseballGame startGame() throws IOException {
		String msg = "";
		System.out.println("game Start!");
		System.out.println("[" + record.getGameNo() + "]번째 게임입니다.");
		System.out.println("랜덤숫자가 생성되었습니다.");

		do {
			System.out.printf("[" + (record.getGameCount() + 1) + "]번째 시도 : ");
			System.out.println("숫자를 입력해주세요 (ex: 123)");
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					System.in));
			String str;
			str = bf.readLine();
			
			if (msg.equals(I)) {
				showGameInfo();
			} else if (isInteger(str)) {
				msg = check.compareComAndUser(random, new RandomNum(
						convertToArray(str), record));
				System.out.println(msg);
			} else {
				System.out.println("숫자만 입력해 주세요");
			}
		} while (msg != null && !msg.equals(HIT));

		if (isRestart()) {
			return startGame();
		}
		return null;
	}

	private static boolean isRestart() throws IOException {
		System.out.println("게임을 다시 시작하시겠습니까? (y/n)");

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine().toLowerCase();

		if (str.equals("y") || str.equals("yes")) {
			return true;
		}
		return false;
	}

	private static int[] convertToArray(String str) {
		int[] userNum = { 0, 0, 0 };
		for (int i = 0; i < str.length(); i++) {
			userNum[i] = str.charAt(i) - 48;
		}
		return userNum;
	}

	private static void showHelpList() {
		System.out.println("==== [Help List] ====");
		System.out.println("[i] : info. 게임정보를 보여줌");
		System.out.println("[r] : reset. 게임을 다시 시작함");
		System.out.println("[s] : start.  게임을 계속 진행함.");
		System.out.println("[exit] : 게임종료");
	}

	private static boolean isInteger(String keyword) {
		boolean check = true;

		for (int i = 0; i < keyword.length(); i++) {
			if (!Character.isDigit(keyword.charAt(i))) {
				check = false;
				break;
			}
		}
		return check;
	}

	public static void main(String[] args) throws IOException {
		init();

		System.out.println("BaseBallGame! ============");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String keyword;

		do {
			keyword = bf.readLine();
			if (!keyword.equals("exit")) {
				menu(keyword);
			}
		} while (!keyword.equals("exit"));

		System.out.println("게임을 종료합니다.");
	}

}
