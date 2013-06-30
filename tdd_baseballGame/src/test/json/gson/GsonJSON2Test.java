package test.json.gson;

import main.core.RandomNum;
import main.core.bean.RecordBoard;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonJSON2Test {

	RecordBoard record = new RecordBoard();
	JsonObject json = new JsonObject();

	@Test
	public void jsonList() {
		Gson gson = new Gson();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			RandomNum randomNum = new RandomNum(record);
			int[] nums = randomNum.getRandomNum();

			json.addProperty(String.valueOf(i), gson.toJson(nums));
		}
		long end = System.currentTimeMillis();

		long result = end - start;
		System.out.println("GSON:PUT) " + result + "_" + result / 1000);
		System.out.println(json);
	}

	@Test
	public void getList() {
		Gson testGson = new Gson();
		String recordData = testGson.toJson(record);
		System.out.println(recordData);
		// 내가 record 객체를 가지고 json으로 나타내고 싶을때.
		// 나는 이걸로 게임기록을 남기려고 할때 쓰면 되겠네
		// 객체인자가 private이어도 가능하다는거
		
		// 만약 내가 json데이터를 읽어와서 record로 변환하고 싶다면?
		RecordBoard record2 = testGson.fromJson(recordData, RecordBoard.class);
		System.out.println(record2.getBallCount());
		System.out.println(record2.getGameCount());
		System.out.println(record2.getGameNo());
	}
	
	@Test
	public void parse() {
		Gson testGson = new Gson();
		record.setGameCount(2);
		record.setGameNo();
		String recordData = testGson.toJson(record);
		
		JsonParser parse = new JsonParser();
		JsonElement el = parse.parse(recordData);
		JsonObject obj = el.getAsJsonObject();

		System.out.println(obj);
	}
}
