package test.designPattern.factory;

import main.constants.Constants;
import main.core.GameNums;
import main.core.pattern.Factory.GameNumsFactory;

import org.junit.Test;

public class GameNumsFactoryTest implements Constants{

	@Test
	public void getObject() throws InstantiationException, IllegalAccessException {
		GameNums randomNum = GameNumsFactory.create(GAME_NAMES.BASEBALL_GAME);
		
		System.out.println(randomNum);
	}
}
