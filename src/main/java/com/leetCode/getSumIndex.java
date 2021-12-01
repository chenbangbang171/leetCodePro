package com.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/***
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * */
/***
 * 思路： 遍历数组，先判断这个数字在map里存不存在（一开始map是空的），如果不存在，就把用target减去当前数字的差值作为key，当前数字的下标存进map。
 *       这样往后找，如果找到剩下的差值，就把这个差值的下标存进结果集，用这个差值去map取value，就是这个值对应的另一个值的下标。
 *       比如2 7 9 ，先在map中找2，找不到，把9-2和2的下标存到map，然后往后找。如果找到了7，就把7的下标存到结果集，再用7取value（就是取2的下标），这样7和2的下标都找到了
 * */
public class getSumIndex {
    public static int[] twoSum(int[] nums, int target) {
        int[] result  = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            // 将数据存入 key为补数 ，value为下标
            map.put(target-nums[i],i);
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = {3,3}; // 1 8   1  7
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}

