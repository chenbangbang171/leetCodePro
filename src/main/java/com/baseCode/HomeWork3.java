package main.java.baseCode;

public class HomeWork3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5,7,9,2,4,6,8,10};
		
//		System.out.println("最大下标：" + maxMark(arr));
//		
//		System.out.println("最小下标：" + minMark(arr));
//		
//		System.out.println("元素位置：" + getTheMark(arr, 4));
//		
//		System.out.println("逆序输出：" );
//		getTheReverse(arr);
		
		
	}
	
	public static int maxMark(int[] arr) {
		int max = arr[0];
		int mark = 0;
		for (int i = 1; i <arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
				mark = i;
			}
		}
		return mark;
	}
	
	public static int minMark(int[] arr) {
		int min = arr[0];
		int mark = 0;
		for (int i = 1; i <arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
				mark = i;
			}
		}
		return mark;
	}
	
	
	public static int getTheMark(int[] arr,int num) {
		int mark = 0;
		for (int i = 1; i <arr.length; i++) {
			if(num  == arr[i]) {
				mark = i;
			}
		}
		return mark;
	}
	
	
	public static void getTheReverse(int[] arr) {
		int[] arr2 = new int[10];
		for (int i = arr.length-1; i >= 0; i--) {
				arr2[9 - i] = arr[i];	
		}
		
		for ( int i = 0; i < arr.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
	
	
}
