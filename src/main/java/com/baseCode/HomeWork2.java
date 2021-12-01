package main.java.baseCode;

public class HomeWork2 {

	public static void main(String[] args) {
		// System.out.println(isMyUpper('A'));

		// System.out.println(maxOfNumber(5,10));

		// System.out.println(minOfNumber(1.2 , 3.4));

		// System.out.println(isMyUpper('A'));

		// System.out.println(isMyNumber('1'));

		// System.out.println(isMyNumber('A'));

		// reverse(1234);

		// System.out.println(toMyLower('A'));

		// System.out.println(cube(2));

		// System.out.println(isLeap(1024));

		// isPositiveNumber(1);

		// System.out.println(s1(15));
		// System.out.println(s1_1(15));

//		for(int i = 1; i <= 15; i++ )
//		System.out.print(fabonaci(i) + " ");
		// fabonaci_1(9);

		// apartNum(53);
		// apartNumber(90);

		// rectgl(7,7);// 传入行数，打印矩形

		// tragl(7);//传入行数,输出直角三角形

		// tragl_1(7);//传入行数，输出等腰三角形

	}

	/**
	 * 返回两个整数里的较大那个
	 * 
	 * @param num1 int 类型
	 * @param num2 int 类型
	 * @return 返回两个整形数中较大的那个
	 */
	public static int maxOfNumber(int num1, int num2) {
		return num1 >= num2 ? num1 : num2;
	}

	/**
	 * 返回两个浮点数里的较小那个
	 * 
	 * @param num1 float类型
	 * @param num2 float 类型
	 * @return 返回两个浮点形数中较小的那个
	 */
	public static double minOfNumber(double num1, double num2) {
		return num1 < num2 ? num1 : num2;
	}

	/**
	 * 判断一个字符是否是大写字母
	 * 
	 * @param c char类型
	 * @return 如果是大写字母，返回true，否则返回false
	 */
	public static boolean isMyUpper(char c) {
		return c >= 'A' && c <= 'Z';
	}

	/**
	 * 判断一个字符是否是数字字符
	 * 
	 * @param c char类型
	 * @return 如果是数字字符，返回true，否则返回false
	 */
	public static boolean isMyNumber(char c) {
		return c >= '1' || c <= '9';
	}

	/**
	 * 判断一个字符是否是英文字母
	 * 
	 * @param c char类型
	 * @return 如果是英文字母，返回true，否则返回false
	 */
	public static boolean isMyEnglish(char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	/**
	 * 判断一个字符，如果是大写字母那么转化为小写然后返回，否则不变
	 * 
	 * @param c char类型
	 * @return 返回一个小写字母
	 */
	public static String toMyLower(char c) {
		if (c >= 'A' && c <= 'Z') {
			String str = c + "";
			return str.toLowerCase();
		}
		return c + "";
	}

	/**
	 * 将一个正整数，倒序打印输出!
	 * 
	 * @param number int类型
	 * 
	 */
	public static void reverse(int number) {
		while (number > 0) {
			System.out.print(number % 10 + " ");
			number /= 10;
		}
	}

	/**
	 * 接收一个double类型数据，计算该数的立方并返回
	 * 
	 * @param number double类型
	 * @return 返回该数字的立方
	 */
	public static double cube(double number) {
		return Math.pow(number, 3);
	}

	/**
	 * /*接收一个年份，判断是平年还是闰年
	 * 
	 * @param year int类型
	 * @return 如果是闰年 返回true 否则返回false
	 * 
	 */

	public static boolean isLeap(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 接收一个整形数，判断是否是正数
	 * 
	 * @param num int类型
	 */
	public static void isPositiveNumber(int num) {
		if (num > 0) {
			System.out.println("YES");
		} else
			System.out.println("NO");
	}

	/**
	 * 接收一个整形数，返回该数的阶乘
	 * 
	 * @param num int类型
	 * @param     return 返回一个整形数的阶乘
	 */
	public static long s1(int num) {
		if (num == 1) {
			return 1;
		} else {
			return num * s1(num - 1);
		}
	}

	public static long s1_1(int num) {
		long sum = 1l;
		for (int i = 1; i <= num; i++) {
			sum *= i;
		}
		return sum;
	}

	/**
	 * 接收一个整数，输出该数个斐波那契数列
	 * 
	 * @param num int类型
	 */
	public static int fabonaci(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fabonaci(num - 1) + fabonaci(num - 2);
		}
	}

	public static void fabonaci_1(int num) {
		int[] count = new int[100];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= num; i++) {
			count[i] = count[i - 1] + count[i - 2];
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				System.out.println(count[i]);
		}
	}

	/**
	 * 接收一个整数，将该整数分解，拆分质因数
	 * 
	 * @param num int类型
	 */
	public static int apartNum(int num) {
		if (num % 2 == 0) {
			System.out.print(2 + " ");
			return apartNum(num / 2);
		} else if (num % 3 == 0) {
			System.out.print(3 + " ");
			return apartNum(num / 3);
		} else if (num % 5 == 0) {
			System.out.print(5 + " ");
			return apartNum(num / 5);
		} else if (num % 7 == 0) {
			System.out.print(7 + " ");
			return apartNum(num / 7);
		} else if (num % 9 == 0) {
			System.out.print(9 + " ");
			return apartNum(num / 9);
		} else
			return num;
	}

	public static void apartNumber(int num) {
		while (true) {
			if (num % 2 == 0) {
				System.out.print(2 + " ");
				num /= 2;
			} else if (num % 3 == 0) {
				System.out.print(3 + " ");
				num /= 3;
			} else if (num % 5 == 0) {
				System.out.print(5 + " ");
				num /= 5;
			} else if (num % 7 == 0) {
				System.out.print(7 + " ");
				num /= 7;
			} else if (num % 9 == 0) {
				System.out.print(9 + " ");
				num /= 9;
			} else {
				System.out.print(num);
				break;
			}
		}

	}

	public static void rectgl(int num1, int num2) {
		for (int i = 1; i <= num1; i++) {

			for (int j = 1; j <= num2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void tragl(int num1) {
		for (int i = 1; i <= num1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void tragl_1(int num1) {
		for (int i = 1; i <= num1; i++) {
			for (int j = i; j <= num1; j++) {
				System.out.print(" ");
			}

			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			for (int m = 1; m < i; m++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
