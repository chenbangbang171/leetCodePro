package com.leetCode;

import java.util.Arrays;

public class maxarray {
	
	public static void main(String[] args) {
		
		int[] arr = {3,4,5,2};
		System.out.println(maxProduct(arr));
	}
	
	//求出一个数组中最大和第二大值减一后的乘积
	 public static int maxProduct(int[] nums) {
	        Arrays.sort(nums);//快排
	        
	        return (nums[nums.length-1] - 1) * (nums[nums.length-2] - 1);
	        
	        
	    }

	public int[] numMovesStones(int a, int b, int c) {
		int[] arr = {a,b,c};
		Arrays.sort(arr);
		int[] result = {0,0};


		if(arr[2] - arr[1] == 1 && arr[1] - arr[0] == 1) return result;

		if(arr[0] != arr[1]-1 && arr[2] != arr[1]+1) result[0] = 2;
		if((arr[0] == arr[1]-1 && arr[2] != arr[1]+1) || (arr[0] != arr[1]-1 && arr[2] == arr[1]+1) || (arr[1] -arr[0] == 2) || (arr[2] - arr[1] == 2)) result[0] = 1;
		result[1] = arr[2] - arr[0] -2;

		return  result;

		/****
		 abs(a-b) a ~ b
		1 3 5
		 */
	}


}
