package com.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class findThreeSumIsZero {

    //     -15 -10 -10 -8 -3 -1 -1  0 1 2 4 5 9 12
    /***
     *
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * -15 -10 -10 -8 -3 -1 -1  0 1 2 4 5 9 12
     *      1.两个正数一个负数
     *          任意俩正数相加去负数寻找相反数
     *      2.两个负数一个正数
     *          任意俩负数相加去正数寻找相反数
     *      3.一个正数一个负数一个零（正负数互为相反数）
     *          对任意数字寻找相反数；注意重复三元组。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) return null;
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> biggerNumbers = numbers.stream().filter(x -> x > 0).collect(Collectors.toList());
        List<Integer> smallerNumbers = numbers.stream().filter(x -> x < 0).collect(Collectors.toList());
        int[] biggerNumbersArray = biggerNumbers.stream().mapToInt(Integer::valueOf).toArray();
        int[] smallerNumbersArray = smallerNumbers.stream().mapToInt(Integer::valueOf).toArray();

        HashSet<Integer> set = new HashSet<>(biggerNumbers);
        boolean containsZero = numbers.contains(0);

        ArrayList<List<Integer>> result = new ArrayList<>();
        find(biggerNumbersArray,smallerNumbers,result);
        find(smallerNumbersArray,biggerNumbers,result);

        if (containsZero){
            find2(set,smallerNumbers,result);
            result.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
        }
        return  result;
    }

    private  static void find(int[]  arr1 ,List<Integer> list2,ArrayList<List<Integer>> result){
        // 2.两个负数一个正数
        for (int i = 0; i < arr1.length - 1;i++){
            for (int j = i + 1; j < arr1.length;j++){
                ArrayList<Integer> arrayList = new ArrayList<>();
                int x = arr1[i];
                int y = arr1[j];
                int sum = arr1[i]+arr1[j];
                if(list2.contains(-sum)){
                    arrayList.add(x);
                    arrayList.add(y);
                    arrayList.add(-sum);
                    result.add(arrayList);
                }
            }
        }
    }
    private static void find2(HashSet<Integer> set,List<Integer> list,ArrayList<List<Integer>> result){
        set.stream().forEach(x->{
            if (list.contains(-x)){
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(x);
                arrayList.add(0);
                arrayList.add(-x);
                result.add(arrayList);
            }
        });
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(0);
        result.add(arrayList);
    }

    public static void main(String[] args) {
        int[]   nums = {-15,-10 ,-10 ,-8 ,-3 ,-1 ,-1 , 0 ,1, 2, 4, 5 ,9 ,12 , 21};


        Set<List<Integer>> lists = new HashSet<List<Integer>>(threeSum(nums)) ;

        for (List<Integer> x: lists) {
            for (Integer y: x){
                System.out.print(y+"  ");
            }
            System.out.println();

        }

    }


}
