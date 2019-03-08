package com.b2bSWE.backtracking;

import java.util.ArrayList;
import java.util.List;
/** Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
**/

// https://leetcode.com/problems/restore-ip-addresses/discuss/30944/Very-simple-DFS-solution
// https://www.youtube.com/watch?v=KU7Ae2513h0&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=23&t=0s
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
	    List<String> solutions = new ArrayList<String>();
	    restoreIp(s, solutions, 0, "", 0);
	    return solutions;
	}
	
	private void restoreIp(String ip, List<String> solutions, int idx, String restored, int segment) {
	    if (segment > 4) return;
	    if (segment == 4 && idx == ip.length()) solutions.add(restored); // Goal
	    
	    for (int i=1; i<4; i++) { // choices
	        if (idx+i > ip.length()) break;
	        String s = ip.substring(idx,idx+i);
	        if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue; // constraints
	        restoreIp(ip, solutions, idx+i, restored+s+(segment==3?"" : "."), segment+1);
	    }
	}
}

