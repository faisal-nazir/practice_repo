package pc.ds.trees;

import common.utils.TreeNode;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;

public class BinaryTreePaths {
	
	private static final String SP = "->";
	
	public static List<String> getTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<String>();
		String path = "";
		helper(root, paths, path);
		return paths;
	}
	
	private static void helper(TreeNode root, List<String> paths, String path) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			paths.add(path + root.val);
			return;
		}
		helper(root.left, paths, path + root.val + SP);
		helper(root.right, paths, path + root.val + SP);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = createNewTree();		
		print(root);
		System.out.println();
		List<String> paths = getTreePaths(root);
		for(String path : paths) {
			System.out.println(path);
		}
	}
	
	private static TreeNode createNewTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		return root;
	}
	
	private static void print(TreeNode root) {
		if(root == null) return;
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			Deque<TreeNode> parents = q;
			q = new LinkedList<TreeNode>();
			for(TreeNode parent : parents) {
				System.out.print(parent.val);
				if(parent.left != null) q.offer(parent.left);
				if(parent.right != null) q.offer(parent.right);
			}
			System.out.println();
		}
	}

}
