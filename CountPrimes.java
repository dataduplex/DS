package test1;

public class CountPrimes {

	// Count the number of primes less than N
	public static void main(String[] args) {
		System.out.println(countPrimes(20));
	}
	
    public static int countPrimes(int n) {

		if (n==1) {
			return 0;
		}
    	
    		int count=0;
    		boolean[] notPrimes = new boolean[n];
    		notPrimes[0]=true;
    		notPrimes[1]=true;
    		
    		for (int i=0; i<Math.sqrt(n); i++) {
    			
    			if (notPrimes[i]==false) {
    				for (int j=2;j*i<n;j++) {
    					notPrimes[j*i]=true;
    				}
    			}
    		}
    		
    		for (int i=0;i<n;i++) {
    			if (! notPrimes[i]) {
    				count++;
    			}
    		}
    			
    		return count;
    	
    }
	
}
