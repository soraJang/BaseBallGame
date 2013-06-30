package main.controller;

import main.core.RandomNum;
import main.core.bean.RecordBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Controller
public class GsonController {

	RecordBoard record = new RecordBoard();
	JsonObject json = new JsonObject();

	@RequestMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", randomNums());
		mv.setViewName("jsons/jsonResults");
		
		return mv;
	}
	
	public JsonObject randomNums() {
		Gson gson = new Gson();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			RandomNum randomNum = new RandomNum(record);
			int[] nums = randomNum.getRandomNum();

			json.addProperty(String.valueOf(i), gson.toJson(nums));
		}
		long end = System.currentTimeMillis();

		long result = end - start;
		System.out.println("GSON:PUT) " + result + "_" + result / 1000);
		System.out.println(json);
		return json;
	}

	public String getList() {
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
		
		return recordData;
	}
}
