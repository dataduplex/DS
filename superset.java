package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class superset {

	public static void main(String[] args) {

		// Print super set of the input list
		// For input - 1,2,3,4
		// Output is : [[1, 2, 3, 4], [2, 3, 4], [1, 3, 4], [3, 4], [1, 2, 4], [2, 4], [1, 4], [4], [1, 2, 3], [2, 3], [1, 3], [3], [1, 2], [2], [1], []]
		
		int[] n = new int[] {1,2,3,4};
		System.out.println(subsets(n).toString());
		
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
    		List<List<Integer>> l = new ArrayList<>();
		    		
    		l.add(new ArrayList<Integer>());
		for (int i=0;i<nums.length;i++) {
			computeSubsets(l,nums[i]);
		}

		if (nums.length>0) {
			l.add(new ArrayList<Integer>());
		}
		
		return l;
    }
    
    public static List<List<Integer>> computeSubsets(List<List<Integer>> input, int newElement) {
    		
    		if (input.size()==0) {
			input.add(new ArrayList<Integer>(Arrays.asList(newElement)));
			return input;
		}
    		
    		if (input.size()==1 && input.get(0).size()==0) {
    			input.get(0).add(newElement);
    			return input;
    		}
    		
    		// take a back up of original list
    		ArrayList<List<Integer>> backupList = new ArrayList<>();
    		for (int i=0;i<input.size();i++) {
    			ArrayList<Integer> a = new ArrayList<>();
    			for (int j=0;j<input.get(i).size();j++) {
    				a.add(input.get(i).get(j));
    			}
    			backupList.add(a);
    		}
    		
    		// mutate the original list, add our new element
    		for (int i=0;i<input.size();i++) {
    			input.get(i).add(newElement);
    		}
    		input.add(new ArrayList<Integer>(Arrays.asList(newElement)));    		
    		input.addAll(backupList);
    		return input;
    }
    
}
