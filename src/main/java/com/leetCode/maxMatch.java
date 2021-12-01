package main.java.test;

public class maxMatch {

	public static void main(String[] args) {
		String[] strs = {"abab", "aba", "" };
		longestCommonPrefix(strs);
	}

	public static String  longestCommonPrefix(String[] strs) {
		int len = strs.length;
		
		//如果数组为空返回""
		if (len == 0) {
			return "";
		}
		
		//如果数组长度为1 直接返回
		if (len == 1) {
			return strs[0];
		}

		//将第一个 作为比较结果，依次向后
		String result = strs[0];

		//初始化当前字符串
		String curString;

		for (int i = 1; i < len; i++) {
			
			curString = strs[i];
			
			//如果当前字符串为空串，则直接返回空串
			if (curString.equals("")) {
				return "";
			}
			
			//这个for循环是依次比较两个字符串字符，比较次数为两个长度最小者
			for (int j = 0; j < Math.min(result.length(), curString.length()); j++) {
				
				//若比较到某个字符，并且不相同，则用result截取该长度，保留相同的字符
				if (curString.charAt(j) != result.charAt(j)) {
					result = result.substring(0, j);
				} else {
					//若比较相同，也要截取两者最小长度，因为curString可能是result的子串，例如result="aaa",curString = "aa";
					//这时候就要截取（0，2） ,保留aa
					result = result.substring(0, Math.min(result.length(), curString.length()));
				}
			}

		}
		return result;
	}

}
