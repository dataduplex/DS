package test1;

import java.util.HashMap;
import java.util.Map;

public class FindNonRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given a string, find its first non-repeating character. 
		
		int result = firstUniqChar("");
		System.out.println(result);
	}
	
public static int firstUniqChar(String s) {

    		if (s.length()==0)
    			return -1;
	
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();  

        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (h.containsKey(c)) {
                
                if (h.get(c) >= 0) {
                    h.put(c,-1);    
                } 
                
            } else {
                h.put(c, i);
            }
        }
        
        int min=s.length()-1;
        for (Map.Entry<Character, Integer> entry : h.entrySet())
        {
            
            if (entry.getValue() > -1) {
                if ( entry.getValue() < min )  {
                    min = entry.getValue();
                } 
            }
        }
        
        if (min==s.length()-1 && h.get(s.charAt(min)) == -1 ) {
        		return -1;
        } else {
        		return min;
        }
    }


	public static int firstUniqChar2(String s) {
	    int freq [] = new int[26];
	    for(int i = 0; i < s.length(); i ++)
	        freq [s.charAt(i) - 'a'] ++;
	    for(int i = 0; i < s.length(); i ++)
	        if(freq [s.charAt(i) - 'a'] == 1)
	            return i;
	    return -1;
	}

}
