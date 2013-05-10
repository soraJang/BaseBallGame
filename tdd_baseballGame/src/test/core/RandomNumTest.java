package test.core;

import junit.framework.TestCase;
import main.core.RandomNum;
import main.core.RecordBoard;

import org.junit.Ignore;
import org.junit.Test;

public class RandomNumTest extends TestCase {
	RecordBoard record = new RecordBoard();

	@Test
	public void testGetRandomNum() {
		RandomNum randomNum = new RandomNum(record);

		assertEquals(3, randomNum.getRandomNum().length);
	}

//	@Test
	public void testIsSame() {
		for (int i = 0; i < 3000; i++) {
			RandomNum randomNum1 = new RandomNum(record);
			RandomNum randomNum2 = new RandomNum(record);
			
			assertEquals(false,randomNum1.toString().equals(randomNum2.toString()));
		}
	}
}
