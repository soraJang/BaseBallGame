package test.json.gson;

import main.core.RandomNum;
import main.core.RecordBoard;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonJSONTest {

	RecordBoard record = new RecordBoard();
	JsonObject json = new JsonObject();

	@Before
	public void jsonList() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			RandomNum randomNum = new RandomNum(record);
			int[] nums = randomNum.getRandomNum();

			json.addProperty(String.valueOf(i), randomNum.converToString(nums));
		}
		long end = System.currentTimeMillis();

		long result = end - start;
		System.out.println("GSON:PUT) " + result + "_" + result / 1000);
	}

	@Test
	public void getList() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < json.entrySet().size(); i++) {
			json.get(String.valueOf(i));
		}

		long end = System.currentTimeMillis();
		long result = end - start;
		System.out.println("GSON:GET) " + result + "_" + result / 1000);
	}
}
