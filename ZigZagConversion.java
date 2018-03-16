package test1;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public static void main(String[] args) {
		String r = convert("PAYPALISHIRING",3);
		System.out.println(r);
	}

	/*
	 * 
	 * 	P   A   H   N
		A P L S I I G
		Y   I   R
		
		PAYPALISHIRING -> PAHNAPLSIIGYIR		
		
	 */
	
    public static String convert(String s, int numRows) {
    		
    		ArrayList<List<Character>> arr = new ArrayList<>();
    		
    		for (int i=0; i<numRows;i++) {
    			ArrayList<Character> l = new ArrayList<>();
    			arr.add(l);
    		}
    		
    		int counter = 0;
    		while(true) {
    			
    			for (int j=0;j<numRows && counter<s.length();j++) {
    				arr.get(j).add(s.charAt(counter));
    				counter++;
    			}
    			
    			
    			for (int k=numRows-2; k>0 && counter<s.length(); k--) {
    				arr.get(k).add(s.charAt(counter));
    				counter++;
    			}
    			
    			if (counter>=s.length())
    				break;
    			
    		}
    	
    		String result = "";
    		for (int i=0;i<numRows;i++) {
    			for (int j=0;j<arr.get(i).size();j++) {
    				result = result + arr.get(i).get(j).toString();
    			}
    		}
    		
    		return result;
    }
}
