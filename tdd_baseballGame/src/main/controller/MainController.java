package main.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.core.CompareNum;
import main.core.RandomNum;
import main.core.bean.RecordBoard;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	RecordBoard record;
	RandomNum comNum;
	CompareNum numChecker;

	public void init() {
		record = new RecordBoard();
		comNum = new RandomNum(record);
		numChecker = new CompareNum(record);
	}

	@RequestMapping
	public String index() {
		init();
		return "views/jquery_index";
	}

	@RequestMapping
	public void getData(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int[] serviceNo = convertToArray(request.getParameter("userNum"));
		RandomNum userNo = new RandomNum(serviceNo, record);
		String result = numChecker.compareComAndUser(comNum, userNo);

		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("gameCount", record.getGameCount());
		json.put("gameNo", record.getGameNo());
		response.getWriter().print(json.toString());
	}

	@RequestMapping
	public void restartGame(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		record.setGameCount(0);
		comNum = new RandomNum(record);

		JSONObject json = new JSONObject();
		json.put("gameNo", record.getGameNo());
		response.getWriter().print(json.toString());
	}

	public int[] convertToArray(String str) {
		int[] userNum = { 0, 0, 0 };
		for (int i = 0; i < str.length(); i++) {
			userNum[i] = str.charAt(i) - 48;
		}
		return userNum;
	}

	public boolean isInteger(String keyword) {
		boolean check = true;

		for (int i = 0; i < keyword.length(); i++) {
			if (!Character.isDigit(keyword.charAt(i))) {
				check = false;
				break;
			}
		}
		return check;
	}
	
}
