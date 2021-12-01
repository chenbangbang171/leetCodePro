package main.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6};
		int target = 8;
		
		List<List<Integer>> combinationSum = combinationSum(arr,target);
		for (List<Integer> list : combinationSum) {
			for (int list2 : list) {
				System.out.print(list2 + " ");
			}
			System.out.println();
		}
 
	}
	
	
	/**
	 * 
	 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	 * candidates 中的数字可以无限制重复被选取。
	 * */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        //排序
        Arrays.sort(candidates);
        find(listAll,list,candidates,target,0);
        return listAll;
    }
	
	//2 3 4 5 6 7   8
    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点,即target为0时，本次递归结束，说明已经成功找到了本次递归的结果
        if(target==0){
        	//将本次递归得到的结果集temp加入最后返回结果集中
            listAll.add(tmp);
            return;
        } 
        //if(target<candidates[num]) return;
        
        /**
         * 
         * */
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            //拷贝一份，不影响下次递归
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }

        /***
		 * 2 6  list-temp:[2] target:6
		 * 2 2 4  list-temp:[2,2] target:4
		 * 2 2 2 2 list-temp:[2,2,2] target:2
		 * 2 2 2 2 0 √ list:[2,2,2,2] temp:[2,2,2] target:0
		 * 				listAll.add(temp)
		 *
		 * 2 2 2 2
		 * 2 2 3 1
		 * 2 2 4 0 √
		 * 2 3 3 0 √
		 * 2 4 2
		 * 2 5 1
		 * 2 6 0 √
		 * 3 4 1
		 * 3 5 0 √
		 * 4 4 0 √
		 *
		 * */
        
    }

}
