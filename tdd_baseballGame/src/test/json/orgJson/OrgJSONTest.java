package test.json.orgJson;

import main.core.RandomNum;
import main.core.RecordBoard;

import org.junit.Test;

public class OrgJSONTest {
	
	RecordBoard record = new RecordBoard();
	
	@Test
	public void jsonList(){
		long start = System.currentTimeMillis();
		for (int i = 0; i< 1000000; i++ ){
			RandomNum randomNum = new RandomNum(record);
			int[] nums = randomNum.getRandomNum();
			
//			json.put(i, randomNum.converToString(nums));
		}
		long end = System.currentTimeMillis();
		
		long result = end - start;
		System.out.println(result + "_" + result / 1000);
	}
}
