package test1;

public class FindContSum {

	public static void main(String[] args) {
		int[] arr  = {2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] result = findSum(arr, 0, 15, 0, 15);
		if (result == null) {
			System.out.println("No result");
		} else {
			System.out.println("start: "+result[0]);
			System.out.println("end: "+result[1]);
		}
	}

	
	public static int[] findSum(int[] a, int start, int sum, int currIndex, int currSum) {
	    
		System.out.println("");
		System.out.println("start: "+start);
		System.out.println("sum: "+sum);
		System.out.println("currIndex: "+currIndex);
		System.out.println("currSum: "+currSum);		
		
		
	    if (currIndex>=a.length) {
	        return null;
	    }
	    
	    if ( a[currIndex] == currSum ) {
	        return new int[]{start, currIndex};
	    }
	    
	    if (a[currIndex] > currSum ) {
	    		return findSum(a,currIndex,sum,currIndex,sum);
	    } else {
	    		return findSum(a,start,sum,currIndex+1,currSum-a[currIndex]);
	    }
	    
	}
}
