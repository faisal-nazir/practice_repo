package com.amazon.online;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.knowsh.com/Notes/250479/Given-An-List-Of-Nodes-With-Each-Node-Having-An-ID-And-A-Parent-ID-Determine-Whether-The-List-Is-Given-In-Preorder
// https://aonecode.com/aplusplus/interviewctrl/getInterview/6710392110313328127
/**
 * Given an List of Nodes, with each Node having an ID and a parent ID,
 * determine whether the List is given in preorder.
 */
public class VerifyPreOrder {
	
	public boolean verifyPreOrder(List<Node> nodes) {
		if(nodes == null || nodes.size() <= 1) return true;
		if(nodes.get(0).parentID != null) return false;
		Set<Integer> set = new HashSet<Integer>();
		set.add(nodes.get(0).id);
		for(int i = 1; i < nodes.size(); ++i) {
			int parent = nodes.get(i).parentID;
			if(!set.contains(parent))
				return false;
			set.add(nodes.get(i).id);
		}
		return true;
	}	
	
	private static class Node {
		Integer id;
		Integer	parentID;
	}
}
