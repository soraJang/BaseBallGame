package test.core;

import junit.framework.TestCase;
import main.core.CompareNum;
import main.core.RandomNum;

import org.junit.Test;

public class CompareNumTest extends TestCase {
	RandomNum randomNum;
	
	private void setRandomNum(int[] nums) {
		randomNum = new RandomNum(nums);
	}
	
	@Test
	public void testHit() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_hit = new CompareNum();
		
		assertEquals("hit", check_hit.compareComAndUser(randomNum, new RandomNum(new int[]{1,3,5})));
	}

	@Test
	public void testStrike() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_strike = new CompareNum();
		
		assertEquals("1 strike 0 ball", check_strike.compareComAndUser(randomNum, new RandomNum(new int[]{1,2,7})));
		assertEquals("2 strikes 0 ball", check_strike.compareComAndUser(randomNum, new RandomNum(new int[]{1,3,7})));
	}

	@Test
	public void testBall() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_ball = new CompareNum();
		
		assertEquals("0 strike 1 ball", check_ball.compareComAndUser(randomNum, new RandomNum(new int[]{2, 4,1})));
		assertEquals("0 strike 2 balls", check_ball.compareComAndUser(randomNum, new RandomNum(new int[]{3,7,1})));
		assertEquals("0 strike 3 balls", check_ball.compareComAndUser(randomNum, new RandomNum(new int[]{3,5,1})));
	}
	
	@Test
	public void testOut() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_out= new CompareNum();
		
		assertEquals("out", check_out.compareComAndUser(randomNum, new RandomNum(new int[]{2,4,9})));
	}
	
	@Test
	public void testGetGameCount() {
		setRandomNum(new int[]{5,3,7});
		CompareNum check = new CompareNum();
		
		check.compareComAndUser(randomNum, new RandomNum(new int[]{1,2,3}));
		check.compareComAndUser(randomNum, new RandomNum(new int[]{1,4,5}));
		check.compareComAndUser(randomNum, new RandomNum(new int[]{1,3,5}));
		
		assertEquals(3, check.getGameCount());
	}
}
