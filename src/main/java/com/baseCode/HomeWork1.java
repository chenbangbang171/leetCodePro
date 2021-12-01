package main.java.baseCode;

import java.util.Scanner;

public class HomeWork1 {

	public static void main(String[] args) {
		// s7();
		// int num = 150;
		// System.out.println(s9(num));

		// s10();
		// s11();
		// System.out.println(s12(5,8));
		// s13(12345);
		// s14();
		// s15();
		s16();
		// s17();
		// s18();
		// s19();
		// s20();
		// s13();
	}

	public static void s1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符:");
		char ch = sc.nextLine().charAt(0);
		if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
			System.out.println("yes");
		} else
			System.out.println("no");
	}

	public static void s2() {
		Scanner sc = new Scanner(System.in);
		int sala = sc.nextInt();
		if (sala >= 5000)
			System.out.println("需要交税");
		else
			System.out.println("不需要交税");
	}

	public static void s3() {
		Scanner sc = new Scanner(System.in);
		int date = sc.nextInt();
		if (date % 4 == 0 && date % 100 != 0 || date % 400 == 0)
			System.out.println("是闰年");
		else
			System.out.println("不是闰年");

	}

	public static void s4() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a - b >= 0)
			System.out.println(a - b);
		else
			System.out.println(b - a);
	}

	public static void s5() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		if (a % 2 == 0)
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static void s6() {
		Scanner sc = new Scanner(System.in);
		int date = sc.nextInt();
		if (date >= 1980 && date <= 1989)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	public static void s7() {
		for (int i = 0; i <= 100; i += 2) {
			System.out.println(i);
		}
	}

	public static void s8() {
		for (int i = 1; i < 100; i += 2) {
			System.out.println(i);
		}
	}

	public static int s9(int n) {
		if (n == 1)
			return 1;
		else
			return n + s9(n - 1);
	}

	public static void s10() {

		for (int i = 1; i <= 10000; i++) {
			if (i < 10) {
				if (i % 7 != 0)
					System.out.println(i);
			} else if (i < 99) {
				if (i % 7 != 0 && !judge3(i))
					System.out.println(i);
			} else if (i < 999) {
				if (i % 7 != 0 && !judge(i))
					System.out.println(i);
			} else if (i < 9999) {
				if (i % 7 != 0 && !judge4(i))
					System.out.println(i);
			}
		}
	}

	static boolean judge3(int i) {
		int a = i / 10;// 25 取2
		int b = i - a * 10; // 25 取 5

		if (a == 7) {
			return true;
		} else if (b == 7) {
			return true;
		}

		return false;
	}

	static boolean judge4(int i) {
		int a = i / 1000;// 2564 取2
		int b = (i - a * 1000) / 100; // 2564-2000=564 取 5
		int c = (i - a * 1000 - b * 100) / 10; // 2564-2000-500=64 取 6
		int d = i - a * 1000 - b * 100 - c * 10; // 取4
		if (a == 7) {
			return true;
		} else if (a == 7) {
			return true;
		} else if (c == 7) {
			return true;
		} else if (d == 7) {
			return true;
		}
		return false;
	}

	static boolean judge(int i) {
		int a = i / 100;// 256 取2
		int b = (i - a * 100) / 10; // 256-200=56 取 5
		int c = i - a * 100 - b * 10;
		if (a == 7) {
			return true;
		} else if (b == 7) {
			return true;
		} else if (c == 7) {
			return true;
		}
		return false;
	}

	public static void s11() {
		for (char a = 'a'; a <= 'z'; a++)
			System.out.print(a);
		System.out.println();
		for (char a = 'A'; a <= 'Z'; a++)
			System.out.print(a);
		System.out.println("");
	}

	public static int s12(int a, int b) {
		int result = 0;
		for (int i = a; i <= b; i++) {
			result += i;
		}
		return result;
	}

	public static void s13(int i) {// 笨方法
		int a = i / 10000;// 25643 取2
		int b = (i - a * 10000) / 1000; // 25643-2000=5643 取 5
		int c = (i - a * 10000 - b * 1000) / 100; // 25643-2000-500=643 取 6
		int d = (i - a * 10000 - b * 1000 - c * 100) / 10; // 643 -600 取4
		int e = i - a * 10000 - b * 1000 - c * 100 - d * 10;
		System.out.println(e + " " + d + " " + c + " " + b + " " + a);
	}

	public static void s13() { // 比较快的方法
		int num = 12345;
		while (num > 0) {
			System.out.println(num % 10);
			num /= 10;
		}
	}

	public static void s14() {
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j < 6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void s15() {
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void s16() {
		for (int i = 1; i <= 6; i++) {
			for (int j = i; j <= 5; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			for (int k = 1; k <= i - 1; k++) {
				System.out.print("*");
			}
			for (int k = 6; k >= i; k--) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void s17() {
		for (int i = 1; i <= 7; i++) {
			for (int j = i; j <= 6; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			for (int k = 1; k <= i - 1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		for (int i = 1; i <= 6; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}
			for (int k = 6; k >= i; k--) {
				System.out.print("*");
			}
			for (int j = i; j < 6; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}


	public static void s18() {
		char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		for (int i = 0; i <= 25; i++) {

			for (int j = i; j < 25; j++) {
				System.out.print(" ");
			}

			for (int j = 0; j <= i; j++) {
				System.out.print(ch[j]);
			}
			System.out.print("");
			for (int j = i - 1; j >= 0; j--) {
				System.out.print(ch[j]);
			}
			System.out.println();
		}

		for (int i = 0; i <= 25; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k < 25 - i; k++) {
				System.out.print(ch[k]);
			}
			for (int m = 23 - i; m >= 0; m--) {
				System.out.print(ch[m]);
			}
			System.out.println(" ");
		}

	}

	public static void s19() {
		for (int i = 1; i <= 4; i++) {

			for (int j = i; j <= 3; j++) {
				System.out.print("#");
			}
			System.out.print("*");

			for (int k = 1; k < i; k++) {
				System.out.print("#");
			}

			for (int m = 1; m < i - 1; m++) {
				System.out.print("#");
			}

			if (i != 1)
				System.out.print("*");
			for (int o = 3; o >= i; o--) {
				System.out.print("#");
			}
			System.out.println("");
		}

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("#");
			}
			System.out.print("*");
			for (int k = 3; k > i; k--) {
				System.out.print("#");
			}
			for (int m = i; m < 2; m++) {
				System.out.print("#");
			}
			if (i != 3)
				System.out.print("*");
			for (int q = 1; q <= i; q++) {
				System.out.print("#");
			}
			System.out.println("");
		}

	}

	public static void s20() {
		for (int i = 1; i <= 3; i++) {
			for (int j = i; j <= 2; j++) {
				System.out.print("     ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("💖");// ♥
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("💖");
			}
			for (int j = i; j <= 3; j++) {
				System.out.print("     ");
			}
			for (int j = i; j <= 3; j++) {
				System.out.print("     ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("💖");// ♥
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("💖");
			}
			System.out.println("");
		}
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("     ");
			}
			for (int k = i; k <= 6; k++) {
				System.out.print("💖");
			}
			for (int m = i; m <= 6; m++) {
				System.out.print("💖");
			}
			System.out.println("");
		}
	}
}
