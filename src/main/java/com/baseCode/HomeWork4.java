package main.java.baseCode;

public class HomeWork4 {

	public static void main(String[] args) {
		// 初始化实验数组
		//int[] arr = { 0 , 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 2, 0 , 4, 5, 6, 5, 6, 3, 4, 7, 8, 1,0, 2, 3, 4, 2, 6, 7, 4 };// 28个
		int[] arr = { 0 , 0,0,0,0,0,0,0 };
		int[] arr2 = new int[20];
		arr2[0] = 1;
		// System.out.println(getTheLastAppeare(arr, 4));

		// getAllTheLastAppeare(arr, 4);

//		insertTheNumber(arr2,58,5);
//		insertTheNumber(arr2,68,5);
//		insertTheNumber(arr2,78,5);
//		insertTheNumber(arr2,88,5);
//		insertTheNumber(arr2,98,5);
//		print(arr2);

//		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};
//		deleNumberFromArr(array, 4);
//		print(array);
//		
//		getTheMaxToFirst(array);
//		print(array);

//		getTheRestMaxToSecond(array);
//		print(array);

//		for (int i =0 ; i < arr.length; i++) {
//			if (getAllTheLastAppeare(arr, 0, i) != -1) {
//				System.out.println(getAllTheLastAppeare(arr, 0, i));
//			}
//		}

	}


	public static int getTheLastAppeare(int[] arr, int num) {
		int mark = 0;
		for (int i = 1; i < arr.length; i++) {
			if (num == arr[i]) {
				mark = i;
			}
		}
		return mark;
	}

	public static int getAllTheLastAppeare(int[] arr, int num, int i) {
		return num == arr[i] ? i : -1;
	}

	public static void insertTheNumber(int[] arr, int num, int posi) {// {0，0，0，0， 5 ，0，0，7，0，7} posi=5 count = 4 length
																		// = 10 num=88
//		int count = 0;												 // 
//		for(int i = 0; i <arr.length; i++) {
//			if(arr[i] != 0) {
//				count++;
//			}
//		}
//		
//		//System.out.println(count + "  " + arr.length );
//
//		if(count == arr.length) {
//			System.out.println(count + arr.length + "数组已满，不能再插入元素！");
//		}
//		
//		if(posi < count) {
//			arr[posi] = num;
//		}else {
		for (int i = arr.length - 2; i >= posi - 1; i--) {
			arr[i + 1] = arr[i];
		}
		arr[posi - 1] = num;

	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}
	}

	public static void deleNumberFromArr(int[] arr, int posi) {
		for (int i = posi; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
	}

	public static void deleNumberFromArr2(int[] arr, int posi) {
		for (int i = posi; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = 0;
	}

	public static void getTheMaxToFirst(int[] arr) {
		int max = arr[0];
		int mark = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				mark = i;
			}
		}

		for (int i = mark - 1; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = max;
	}

	public static int getTheMax(int[] arr) {
		int max = arr[0];
		int mark = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				mark = i;
			}
		}
		return max;
	}

	public static void getTheRestMaxToSecond(int[] arr) {
		int max = getTheMax(arr);
		int mark = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				mark = i;
			}
		}

		for (int i = mark - 1; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[1] = max;

	}

}
