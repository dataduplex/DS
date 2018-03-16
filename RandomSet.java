package test1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomSet {

	
    HashMap<Integer, Integer> randomObj;
    HashMap<Integer, Integer> objIndexes;
    ArrayList<Integer> keyList;
    
    /** Initialize your data structure here. */
    public RandomSet() {
        randomObj = new HashMap<>();
        objIndexes = new HashMap<>();
        keyList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (randomObj.containsKey(val))
            return false;
        else {
        		randomObj.put(val, val);
        		keyList.add(val);
        		objIndexes.put(val, keyList.size()-1);
        		System.out.println("List size after insert: "+keyList.size());
        		System.out.println("List after insert: "+keyList.toString());
        		return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
	    	if (! randomObj.containsKey(val))
	            return false;
	    	else {
	    		randomObj.remove(val);
	    		int ind = objIndexes.get(val);
	    		
	    		int last = keyList.size()-1;
	    		
	    		if (ind==last) {
	    			keyList.remove(ind);
	    		} else {
	    			keyList.add(ind, keyList.get(last));
	    			keyList.remove(last);
	    		}
	    		
	    		System.out.println("List size after remove: "+keyList.size());
	    		System.out.println("List after remove: "+keyList.toString());
	    		objIndexes.remove(val);
	    		
	    		return true;
	    	}
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    		Random r = new Random();
    		int rand = r.nextInt(keyList.size());
    		//System.out.println("keyList.size()=="+keyList.size());
    		//System.out.println("rand=="+rand);
    		return randomObj.get(keyList.get(r.nextInt(keyList.size())));
    		
    }
	
	
	public static void main(String[] args) {
		
		RandomSet s = new RandomSet();
		s.insert(0);
		s.insert(1);
		s.remove(0);
		s.insert(2);
		s.remove(1);
		//s.getRandom();
		
	}

}
