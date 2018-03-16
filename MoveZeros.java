package test1;

import java.util.Arrays;

public class MoveZeros {
	//move zeros to end of array
	public static void main(String[] args) {
		int[] a = { 1,2,0,5,6,0,8,9,10,0,0,11 };
		moveToLeft2(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void moveToLeft(int[] n) {
		
		int zeroCount = 0;
		int i = 0;
		
		for (i=0;i<n.length;i++) {
			if (n[i]==0) {
				zeroCount++;
				continue;
			}
			if (zeroCount>0) 
				n[i-zeroCount] = n[i];
		}
		
		for (i=n.length-zeroCount;i<n.length;i++) {
			n[i]=0;
		}
	}
	
	
	public static void moveToLeft2(int[] n) {
		
		int zeroBeginIndex = 0;
		for (int i=0; i<n.length; i++) {
			
			if (n[i]==0) {
				continue;
			}
			
			swap(zeroBeginIndex,i,n);
			zeroBeginIndex++;
		}
	}
	
	public static void swap(int a, int b, int[] arr) {

		if (a==b)
			return;
		
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	 
}
