package com.epi.hashtables;

import java.util.*;

public class LCAWithOptimization {

	// EPI-13.4: COMPUTE THE LCA, OPTIMIZING FOR CLOSE ANCESTORS
	
	private class Node {
		int value;
		Node left; 
		Node right;
		Node parent;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	// ascend the tree from both nodes in tandem
	// this solution trades space for time.
	// O(D1+D2) where D1 is the distance of n1 from LCA and D2 is the distance of LCA from n2.
	public static Node computeLCA(Node n1, Node n2) {
		Set<Node> set = new HashSet<>();
		while(n1 != null || n2 != null) {
			if(n1 != null)  {
				if(!set.add(n1))
					return n1;
				n1 = n1.parent;
			}
			if(n2 != null) {
				if(!set.add(n2))
					return n2;
				n2 = n2.parent;
			}
		}
		throw new IllegalArgumentException("Node n1 and n2 does not belong to same tree");
		
	}
}
