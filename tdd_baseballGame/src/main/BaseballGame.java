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
			System.out.println("������ ���Ͻø� help�� �Է����ּ���");
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
		System.out.println("[" + record.getGameNo() + "]��° �����Դϴ�.");
		System.out.println("�������ڰ� �����Ǿ����ϴ�.");

		do {
			System.out.printf("[" + (record.getGameCount() + 1) + "]��° �õ� : ");
			System.out.println("���ڸ� �Է����ּ��� (ex: 123)");
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
				System.out.println("���ڸ� �Է��� �ּ���");
			}
		} while (msg != null && !msg.equals(HIT));

		if (isRestart()) {
			return startGame();
		}
		return null;
	}

	private static boolean isRestart() throws IOException {
		System.out.println("������ �ٽ� �����Ͻðڽ��ϱ�? (y/n)");

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
		System.out.println("[i] : info. ���������� ������");
		System.out.println("[r] : reset. ������ �ٽ� ������");
		System.out.println("[s] : start.  ������ ��� ������.");
		System.out.println("[exit] : ��������");
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

		System.out.println("������ �����մϴ�.");
	}

}
