package com.leetCode;

import java.util.*;

public class MaxNumber {

    public static String largestNumber(int[] nums) {
        //只有一个直接返回
        if (nums.length == 1) return nums[0]+"";
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        //初始化字符串
        StringBuilder result = new StringBuilder();
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1) ? 1 : 0;
            }
        });

        for (String x: strArr) {
            result.append(x);
        }

        return result.toString();
    }

//    private static int compare(Integer x, Integer y){
//        String xx = String.valueOf(x);
//        String yy = String.valueOf(y);
//        return  Integer.parseInt(xx+yy) > Integer.parseInt(yy+xx) ? 1 : 0;
//    }

    public static void main(String[] args) {
        int[] arr = {10,2};

        System.out.println(largestNumber(arr));
    }
}
