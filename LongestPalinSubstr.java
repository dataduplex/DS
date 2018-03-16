package test1;

public class LongestPalinSubstr {

	// Find the longest palindromic substring within a string
	public static void main(String[] args) {
		//String r = longestPalindromeDP("jaynthan");
		String r = longestPalindromeDP("cbbd");
		System.out.println(r);
	}
	
	public static String longestPalindrome(String s) {		
		int start;
		int end;
		
		for (int i=0; i<s.length();i++) { // n
			start = 0;
			end = s.length()-1-i;
			
			while (end<s.length()) { //n
				if (checkPalindrome(s, start, end)) { //n
					return s.substring(start, end+1);
				}
				start++;
				end++;
			}	
		}
		return null;		
	}
	
	public static boolean checkPalindrome(String str, int start, int end) {
		
		while(start<=end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	
	public static String longestPalindromeDP(String s) {
		
		if (s.length()==0)
			return null;
		
		boolean[][] palindromeMatrix = new boolean[s.length()][s.length()];
		
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<s.length();j++) {
				palindromeMatrix[i][j]=false;
			}
		}
		
		for (int i=0; i<s.length(); i++) {
			palindromeMatrix[i][i]=true;
		}
		
		int max_length=0;
		int max_lo = -1, max_hi = -1;
		for (int gap=1; gap<s.length();gap++) {
			for (int lo=0, hi=gap; hi<s.length(); lo++,hi++) {
				
				if (hi-lo == 1) {
					if (s.charAt(lo)==s.charAt(hi)) {
						palindromeMatrix[lo][hi]=true;
						if (hi-lo+1>max_length) {
							max_length = hi - lo + 1;
							max_lo=lo;
							max_hi=hi;
						}
					} else {
						palindromeMatrix[lo][hi]=false;
					}
					continue;
				}
				
				if (palindromeMatrix[lo+1][hi-1]==true && s.charAt(lo)==s.charAt(hi)) {
					palindromeMatrix[lo][hi]=true;
					if (hi-lo+1>max_length) {
						max_length = hi - lo + 1;
						max_lo=lo;
						max_hi=hi;
					}
				} else {
					palindromeMatrix[lo][hi]=false;
				}				
			}			
		}
		
		
		for (int i=0; i<s.length();i++) {
			System.out.println("");
			for (int j=0;j<s.length();j++) {
				System.out.print(palindromeMatrix[i][j]);
				System.out.print(" ");
			}
		}
		
		
		if (max_length>1) {
			return s.substring(max_lo, max_hi+1);
		} else {
			return s.substring(0,1);
		}
	}
}
