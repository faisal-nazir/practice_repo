package interview.pro.daily.problem;

public class CountUnivalSubTrees {

	// https://leetcode.com/problems/count-univalue-subtrees/
	public static int count(Node root) {
		if(root == null) return 0;
		int left_count = count(root.left);
		int right_count = count(root.right);
		
		int count = left_count + right_count;
		if((root.left == null || root.left.value == root.value) && (root.right == null || root.right.value == root.value))
				++count;
		return count;
	}
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static void main(String[] args) {
		Node root = getTree();
		System.out.print(count(root));
		
	}
	
	private static Node getTree() {
		Node root = new Node(0);
		root.left = new Node(1);		
		root.right = new Node(0);
		
		root.right.left = new Node(1);
		root.right.right = new Node(0);
		
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(1);
		
		return root;
	}
	
}
