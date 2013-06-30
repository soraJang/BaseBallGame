package main.core.pattern.Factory;

import main.constants.Constants;
import main.core.GameNums;
import main.core.RandomNum;

public class GameNumsFactory implements Constants {
	
	public static GameNums create(String gameName) {
		if (gameName.equals(GAME_NAMES.BASEBALL_GAME)) {
			return new RandomNum(new main.core.bean.RecordBoard());
		} else {
			return null;
		}
	}
	
//	private static Map<String, Class> gameNumMap = new HashMap<String, Class>();
//	static {
//		
//	}
//	
//	public static GameNums create(String gameName) throws InstantiationException, IllegalAccessException {
//		return (GameNums)gameNumMap.get(gameName).newInstance();
//	}
}
