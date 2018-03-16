package test1;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,4,5,6,7,8};
		System.out.println(Arrays.toString(arr));
		rotate(arr,8);
		System.out.println(Arrays.toString(arr));

	}
	
	
    public static void rotate(int[] nums, int k) {
    
    		if (k==0)
    			return;
    		
    		if (k>nums.length) 
    			k = k%nums.length;
    		
    		int[] temp = new int[k];   	
    		int cnt = 0;
    		for (int i=nums.length-k; i<nums.length; i++) {
    			temp[cnt] = nums[i];
    			cnt++;
    		}
    		
    		int dest;
    		for (int i=nums.length-k-1; i>=0; i--) {
    			dest = i+k;
    			nums[dest] = nums[i];
    		}
    		
    		for (int i=0;i<k;i++) {
    			nums[i] = temp[i];
    		}
    }

}
