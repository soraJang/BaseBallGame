package main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.core.RecordBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import flexjson.JSONSerializer;

@Controller
public class FlexController {
	RecordBoard record = new RecordBoard();
	JSONSerializer serializer = new JSONSerializer();
	
	@RequestMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", randomNums());
		mv.setViewName("jsons/jsonResults");
		
		return mv;
	}

	public String record() {
		record.setBallCount(2);
		record.setStrikeCount(2);
		record.setGameNo();
		record.setGameCount(4);

		return serializer.serialize(record);
	}

	public String randomNums() {
		RandomNums randomNums = new RandomNums();
		randomNums.setNo(1);
		List<int[]> nums = new ArrayList<int[]>();
		nums.add(new int[] { 1, 2, 3 });
		nums.add(new int[] { 3, 7, 1 });
		randomNums.setNumList(nums);
		
		serializer.rootName("result");
		serializer.serialize(randomNums);

		return serializer.include("numList").serialize(randomNums);
	}
}

class RandomNums {
	@Override
	public String toString() {
		return "RandomNums [no=" + no + ", nums=" + Arrays.toString(nums) + "]";
	}

	public int no;
	public int[] nums;
	public List<int[]> numList;

	public List<int[]> getNumList() {
		return numList;
	}

	public void setNumList(List<int[]> numList) {
		this.numList = numList;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}
}