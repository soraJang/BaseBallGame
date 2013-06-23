package test.json.net.sf.json;

import main.core.RandomNum;
import main.core.RecordBoard;
import net.sf.json.JSONObject;

import org.junit.Before;
import org.junit.Test;


public class NormalJSONTest {

	RecordBoard record = new RecordBoard();
	JSONObject json = new JSONObject();

	@Before
	public void jsonList() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			RandomNum randomNum = new RandomNum(record);
			int[] nums = randomNum.getRandomNum();

			json.put(i, randomNum.converToString(nums));
		}
		long end = System.currentTimeMillis();

		long result = end - start;
		System.out.println("JSON:PUT) " + result + "_" + result / 1000);
	}

	@Test
	public void getList() {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < json.size(); i++) {
			json.get(String.valueOf(i));
		}

		long end = System.currentTimeMillis();
		long result = end - start;
		System.out.println("JSON:GET) " + result + "_" + result / 1000);
	}
}
