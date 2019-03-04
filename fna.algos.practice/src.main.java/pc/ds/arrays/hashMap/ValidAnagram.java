package pc.ds.arrays.hashMap;

import java.util.HashMap;

public class ValidAnagram {

	/** Given two strings s and t , write a function to determine if t is an anagram of s.

		Example 1:
		
		Input: s = "anagram", t = "nagaram"
		Output: true
		Example 2:
		
		Input: s = "rat", t = "car"
		Output: false
		Note:
		You may assume the string contains only lowercase alphabets.
		
		Follow up:
		What if the inputs contain unicode characters? How would you adapt your solution to such case?
	**/
	
	// Approach 01: Sorting
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content); // is a modified quick sort (uses two pivots).
		return new String(content);
	}
	
	public static boolean isAnagram_01(String s, String t) {
		return sort(s).equals(sort(t));
	}
	
	// Approach 02: count frequency using array (optimized for ASCII character set)
	public static boolean isAnagram_02(String s, String t) {
		if (s.length() != t.length()) return false; // Permutations must be same length
		
		int[] letters = new int[128]; // Assumption: ASCII
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		  
		for (int i = 0; i < t.length(); i++) {
			letters[t.charAt(i)]--;
		    if (letters[t.charAt(i)] < 0) {
		    	return false;
		    }
		}
		  
		return true; // letters array has no negative values, and therefore no positive values either
	}
	
	// Apporach 03: Hashtable
	// same idea as above but using HashMap to support unicode characters
	
	public static boolean isAnagram_03(String s, String t) {
		if (s.length() != t.length()) return false; // Permutations must be same length
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();    
		 
	    for(int i=0; i<s.length(); i++){
	        char c1 = s.charAt(i);
	        if(map.containsKey(c1)){
	            map.put(c1, map.get(c1)+1);
	        }else{
	            map.put(c1,1);
	        }
	    }
	 
	    for(int i=0; i<s.length(); i++){
	        char c2 = t.charAt(i);
	        if(map.containsKey(c2)){
	            if(map.get(c2)==1){
	                map.remove(c2);
	            }else{
	                map.put(c2, map.get(c2)-1);
	            }
	        }else{
	            return false;
	        }    
	    }
	 
	    if(map.size()>0)
	        return false;
	 
	    return true;
	}
}
