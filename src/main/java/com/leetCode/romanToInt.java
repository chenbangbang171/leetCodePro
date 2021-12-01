package main.java.test;

import java.util.HashMap;

public class romanToInt {
	public static void main(String[] args) {
		System.out.println(romanToInt3("III"));

	}

	
	public static int romanToInt3(String str) {
		/*
		 * 小量数据并不能体现map的效率
		 * */
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		char[] ca = str.toCharArray();

		int length = ca.length;

		int index = 0;

		int result = 0;

		// "III"

		while (index < length) {

			if (index == length - 1) {
				result += map.get(ca[index]);
				index += 1;
			} else {
				if (map.get(ca[index]) < map.get(ca[index + 1])) {
					result -= map.get(ca[index]);
					index += 1;
				} else {
					result += map.get(ca[index]);
					index += 1;
				}
			}

		}
		return result;

	}

	
	private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


}
