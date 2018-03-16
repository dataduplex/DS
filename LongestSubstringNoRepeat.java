package test1;

import java.util.HashMap;

public class LongestSubstringNoRepeat {

	/*
	 * 	Given "abcabcbb", the answer is "abc", which the length is 3.
		"abcabcbb"
		"abcabcbb"
		Given "bbbbb", the answer is "b", with the length of 1.
		Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	
	public static void main(String[] args) {
		int result = lengthOfLongestSubstring("dvdf");
		System.out.println(result);
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
		
		
		if (s.length()==0)
			return 0;
		
		if (s.length()==1)
			return 1;
		
		HashMap<Character, Character> map = new HashMap<>(); 
		map.put(s.charAt(0), s.charAt(0));
		int maxLength=0;
		int currLength=1;
		StringBuffer curr = new StringBuffer();
		curr.append(s.charAt(0));
		
		for (int i=1; i<s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				
				String str = curr.toString();
				curr = new StringBuffer(str.substring(str.indexOf(s.charAt(i))));
				
				for (int j=0; j<str.length();j++) {
					
					if (s.charAt(i)==str.charAt(j)) {
						break;
					} else {
						map.remove(str.charAt(j));
					}
				}
				
				if (currLength>maxLength)
					maxLength = currLength;
				curr.append(s.charAt(i));
				
				
				
			} else {
				currLength++;
				curr.append(s.charAt(i));
			}
			map.put(s.charAt(i), s.charAt(i));
		}
		
		if (currLength>maxLength) {
			maxLength = currLength;
		}
		
		return maxLength;
    }

}
