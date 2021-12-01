package com.leetCode;

import java.util.Arrays;

public class subArraySum {

    /***
     * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2
     * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
     *
     * 示例 2 :
     *
     * 输入:nums = [1,2,3], k = 3
     * 输出: 2
     * */

    public static int getResult(int[] nums, int k){
        int result = 0;
        int size = nums.length;
        if (size == 0 ) return result;

        for (int i = 0; i < size; i++){
            if (nums[i] == k) {
                result += 1;
                break;
            }
            if (i == size -1){
                break;
            }
            //从当前位置往后累加，直到等于k
            //sum 初始为当前值，往后累加
            int sum = nums[i];
            for (int j = i + 1;j < size; j++){
                sum += nums[j];
                if (sum == k){
                    result++;
                    break;
                }
            }
        }

        return  result;
    }


    public static void main(String[] args) {




    }
}
