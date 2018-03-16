package test1;

public class BinaySearch {

	public static void main(String[] args) {
		
		int [] a = {5, 7, 7, 8, 8, 10};
		int found = search(a,10,0,a.length-1);
		System.out.println("found at pos: "+found);
		
		if (found<0)
			return;
		
		int left=found-1;
		int right=found+1;
		while(left > 0 && a[found]==a[left]) 
			left--;
		while(right < a.length && a[found]==a[right])
			right++;
		
		System.out.println("start: " + (left+1));
		System.out.println("end: " + (right-1));
	}
	
	public static int search(int[] n, int k, int start, int end) {
	
		int mid = (start+end)/2;
		
		if (n[mid]==k)
			return mid;
	
		if ( mid - 1 < start || mid + 1 > end) 
			return -1;
		
		if (k>n[mid]) {
			return search(n,k,mid+1,end);
		}
		
		if (k<n[mid]) {
			return search(n,k,start,mid-1);
		}
		
		return -1;
	}

}
