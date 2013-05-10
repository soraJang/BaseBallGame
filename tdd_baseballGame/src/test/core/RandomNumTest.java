package test.core;

import junit.framework.TestCase;
import main.core.RandomNum;

import org.junit.Test;

public class RandomNumTest extends TestCase {

	@Test
	public void testGetRandomNum() {
		RandomNum randomNum = new RandomNum();

		assertEquals(3, randomNum.getNum().length);
	}
}
