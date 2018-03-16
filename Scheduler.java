package test1;

import java.util.Scanner;

public class Scheduler {

	// Schedule table tennis games between 9 am to 6 pm
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	    
        int totalPlayers = Integer.valueOf(input.nextLine());
        int[] startTimes = new int[totalPlayers];
        int[] endTimes = new int[totalPlayers];
        
        int i=0;
	    while (input.hasNext()) {
	    		String[] strArray = input.nextLine().split(" ");
	    		startTimes[i] = Integer.valueOf(strArray[0]);
	    		endTimes[i] = Integer.valueOf(strArray[1]);
	    		
	    		i++;
	    		if (i==totalPlayers) {
	    			break;
	    		}
	    }
		
	    input.close();
	    
		int[] result = calculateHours(startTimes,endTimes);
		System.out.println(result[0]+" "+result[1]);
				
	}
	
	
	static int[] calculateHours(int[] startTimes, int[] endTimes) {
		
		int singlesHours = 0;
		int doublesHours = 0;
	
		int startTime=9;
		int endTime=10;
		
		
		while (startTime<=17 && endTime<=18) {
			
			boolean singlesPossible=false;
			boolean doublesPossible=false;
			int availableCount=0;
			
			for (int i=0; i<startTimes.length; i++) {
				
				if (startTimes[i]<=startTime && endTimes[i]>=endTime) {
					availableCount++;
				}
				
				if (availableCount>=4) {
					doublesPossible = true;
				}
				
				if (availableCount>=2) {
					singlesPossible = true;
				}
				
			}
			
			if (doublesPossible) {
				doublesHours++;
			} else if (singlesPossible) {
				singlesHours++;
			}
		
			startTime++;
			endTime++;
		}
		
		return new int[] {singlesHours,doublesHours};
		
	}

}
