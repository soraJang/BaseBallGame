package test.core;

import junit.framework.TestCase;
import main.core.CompareNum;
import main.core.RandomNum;
import main.core.RecordBoard;

import org.junit.Test;

public class CompareNumTest extends TestCase {
	RandomNum randomNum;
	RecordBoard record = new RecordBoard();
		
	private void setRandomNum(int[] nums) {
		randomNum = new RandomNum(nums, record);
	}
	
	@Test
	public void testHit() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_hit = new CompareNum(record);
		
		assertEquals("hit", check_hit.compareComAndUser(randomNum, new RandomNum(new int[]{1,3,5}, record)));
	}

	@Test
	public void testStrike() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_strike = new CompareNum(record);
		
		assertEquals("1 strike 0 ball", check_strike.compareComAndUser(randomNum, new RandomNum(new int[]{1,2,7}, record)));
		assertEquals("2 strikes 0 ball", check_strike.compareComAndUser(randomNum, new RandomNum(new int[]{1,3,7}, record)));
	}

	@Test
	public void testBall() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_ball = new CompareNum(record);
		
		assertEquals("0 strike 1 ball", check_ball.compareComAndUser(randomNum, new RandomNum(new int[]{2, 4,1}, record)));
		assertEquals("0 strike 2 balls", check_ball.compareComAndUser(randomNum, new RandomNum(new int[]{3,7,1}, record)));
		assertEquals("0 strike 3 balls", check_ball.compareComAndUser(randomNum, new RandomNum(new int[]{3,5,1}, record)));
	}
	
	@Test
	public void testOut() {
		setRandomNum(new int[]{1,3,5});
		CompareNum check_out= new CompareNum(record);
		
		assertEquals("out", check_out.compareComAndUser(randomNum, new RandomNum(new int[]{2,4,9}, record)));
	}
	
	@Test
	public void testGetGameCount() {
		setRandomNum(new int[]{5,3,7});
		CompareNum check = new CompareNum(record);
		
		check.compareComAndUser(randomNum, new RandomNum(new int[]{1,2,3}, record));
		check.compareComAndUser(randomNum, new RandomNum(new int[]{1,4,5}, record));
		check.compareComAndUser(randomNum, new RandomNum(new int[]{1,3,5}, record));
		
		assertEquals(3, record.getGameCount());
	}
}
