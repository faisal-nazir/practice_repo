package interview.pro.daily.problem;

import java.util.*;

public class SymmetricKArrayTree {

	private static class Node {
		int value;
		List<Node> child;
		
		Node(int val, List<Node> child) {
			this.value = val;
			this.child = child;
		}
	}
	
	public static boolean isSymmetric(Node root) {
		if(root == null) return false;
		Deque<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			if(!isSymmetric(new ArrayList<>(q))) return false;
			Deque<Node> parents = q;
			q = new LinkedList<>();
			for(Node n : parents) {
				if(n.child != null)
					q.addAll(n.child);
			}
		}
		return true;
	}
	
	private static boolean isSymmetric(List<Node> list) {
		if(list == null || list.isEmpty()) return false;
		for(int i = 0, j = list.size()-1; i < j; ++i, --j) {
			if(list.get(i).value != list.get(j).value) 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node root = getTree();
		System.out.print(isSymmetric(root));
	}
	
	private static Node getTree() {
		Node root = new Node(4, new ArrayList<Node>());
		root.child.add(new Node(3, new ArrayList<Node>()));
		root.child.add(new Node(3, new ArrayList<Node>()));
		
		root.child.get(0).child.add(new Node(9, new ArrayList<Node>()));
		root.child.get(0).child.add(new Node(4, new ArrayList<Node>()));
		root.child.get(0).child.add(new Node(1, new ArrayList<Node>()));
		
		root.child.get(1).child.add(new Node(9, new ArrayList<Node>()));
		root.child.get(1).child.add(new Node(4, new ArrayList<Node>()));
		root.child.get(1).child.add(new Node(1, new ArrayList<Node>()));
		
		return root;
		
	}
}
