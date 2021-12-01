package main.java.test;

public class sentencePreSearcheWord {

	public static void main(String[] args) {
		String sentence = "this problem is an easy problem";
		String word = "pro";
		System.out.println(isPrefixOfWord(sentence,word));
	}
	
	
	public static int isPrefixOfWord(String sentence, String searchWord) {
		String[] strs = sentence.split(" ");
		
		int index = 0;
		
		//从句子第一个往后开始
		while(index < strs.length) {
			
			//如果单词长度小于前缀长度 直接跳过
			if(strs[index].length() < searchWord.length()) {
				index++;
				continue;
			}
			
			//直接用单词截取前缀长度，比较
			if (strs[index].substring(0, searchWord.length()).equals(searchWord)) {
				return index + 1;
			}else {
				index++;
			}
			
//			//用该单词和搜索前缀依次字符比较
//			for (int i = 0; i < len; i++) {
//				
//				//若出现不相同的
//				if (strs[index].charAt(i) != searchWord.charAt(i) ) {
//					index++;
//					break;
//				}else {
//					count++;
//				}
//			}
//			
//			if(count == len) {
//				return index + 1;
//			}
			
		}
		return -1;
		
    }

}
