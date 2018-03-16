package test1;

public class ReverseWords {

	public static void main(String[] args) {

		// Reverse words in a sentence
		// The Sky is Blue -> Blue is Sky The
		char[] ch = "The Sky is Blue".toCharArray();
		reverseWords(ch);
		System.out.println(ch);
	}

	
    public static void reverseWords(char[] str) {
    	
    		if (str == null || str.length==1)
    			return;
    		
    		int start=0, end=0;
    		
    		while(end<str.length) {
    			if (str[end]==' ') {
    				reverseString(str,start,end-1);
    				start=end+1;
    			} 
    			end++;
    		}
    		reverseString(str,start,end-1);
    		reverseString(str,0,str.length-1);
    }
    
    
    public static void reverseString(char[] str, int start, int end) {
    		char t;
    		while (start<end) {
    			t = str[start];
    			str[start]=str[end];
    			str[end]=t;
    			start++;
    			end--;
    		}    	
    }
    
    
	
}
