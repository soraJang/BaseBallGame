package test.json.flexJson;

import java.util.Arrays;

import main.core.RecordBoard;

import org.junit.Test;

import flexjson.JSONSerializer;

public class FlexJSONTest {
	RecordBoard record = new RecordBoard();
	JSONSerializer serializer = new JSONSerializer();

//	@Test
	public void jsonList() {
		record.setBallCount(2);
		record.setStrikeCount(2);
		record.setGameNo();
		record.setGameCount(4);

		System.out.println(serializer.serialize(record));
	}

	@Test
	public void randomNumsList() {
		RandomNums randomNums = new RandomNums();
		randomNums.setNo(1);
		randomNums.setNums(new int[]{1,2,3});
		
		serializer.rootName("result");
		serializer.serialize(randomNums);

		System.out.println(serializer.toString());
	}
}

class RandomNums {
	@Override
	public String toString() {
		return "RandomNums [no=" + no + ", nums=" + Arrays.toString(nums) + "]";
	}

	public int no;
	public int[] nums;

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
