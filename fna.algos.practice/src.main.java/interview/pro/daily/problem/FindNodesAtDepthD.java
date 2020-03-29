package interview.pro.daily.problem;

import java.util.*;

public class FindNodesAtDepthD {

	// Get all Values at a Certain Height in a Binary Tree
	
	private static class Node {
		int value; 
		Node left;
		Node right;
		
		Node(int val) {
			value = val;
		}		
	}
	
	public static List<Node> find(Node root, int d) {
		if(root == null || d < 0) return null;
		Deque<Node> q = new LinkedList<Node>();
		q.add(root);

		while(d-- > 0) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				Node curr = q.poll();
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
		}
		
		return new ArrayList<Node>(q);
	}
	
	public static void main(String[] args) {
		Node root = getTree();
		List<Node> level = find(root,2);
		print(level);
		System.out.print("END");
	}
	
	private static Node getTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		return root;
	}
	
	private static void print(List<Node> list) {
		for(Node n : list) {
			System.out.print(n.value + " ");
		}
	}
	
}
