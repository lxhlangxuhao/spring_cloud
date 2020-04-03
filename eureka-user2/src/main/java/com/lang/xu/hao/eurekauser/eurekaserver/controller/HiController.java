package com.lang.xu.hao.eurekauser.eurekaserver.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class HiController {

	@RequestMapping("/hi")
	public String hi() {

		return "hi";
	}

	@RequestMapping("/hi2")
	public String hi2() throws InterruptedException {

		Thread.sleep(2000);
		return "hi2";
	}

	public static void main(String[] args) {

		int[] arr = {1, 20, 5, 6, 85, 2, 8, 3};
		int targetInt = 8;
		System.out.println(Arrays.toString(twoSum(arr, targetInt)));

	}

	public static int[] twoSum(int[] nums, int target) {

		Map hashMap = new HashMap<Integer,Integer>();
		for(int i=0,length = nums.length;i<length;i++){

			Integer num1 = target - nums[i];
			if(hashMap.containsKey(num1)){
				return new int[]{i,(Integer)hashMap.get(num1)};
			}else{
				hashMap.put(nums[i],i);
			}
		}
		return null;
	}

}
