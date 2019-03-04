package ctci.ds.tree;

import java.util.List;
import java.util.LinkedList;

import common.utils.TreeNode;

public class ListOfDepths {
	public static List<LinkedList<TreeNode>> getListofDepths(TreeNode root) {
		if(root == null) return null;
		List<LinkedList<TreeNode>> result = new LinkedList<LinkedList<TreeNode>>();
		helper(root, result, 0);
		return result;
	}
	
	private static void helper(TreeNode node, List<LinkedList<TreeNode>> lists, int level) {
		if(node == null) return;
		if(level >= lists.size()) {
			lists.add(new LinkedList<TreeNode>());
		}
		lists.get(level).addLast(node);
		helper(node.left, lists, level+1);
		helper(node.right, lists, level+1);		
	}
	
	public static TreeNode getMinimalTree(int[] input) {
		return getMinimalTree(input, 0, input.length -1);
	}
	
	public static TreeNode getMinimalTree(int[] input, int start, int end) {
		if(start > end) return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(input[mid]);
		root.left = getMinimalTree(input, start, mid -1);
		root.right = getMinimalTree(input, mid + 1, end);
		return root;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		TreeNode root = getMinimalTree(arr);
		List<LinkedList<TreeNode>> result = getListofDepths(root);
		for(List<TreeNode> list : result) {
			print(list);
		}
		
	}
	
	public static void print(List<TreeNode> list) {
		for(TreeNode n : list) {
			System.out.print(n.val + ",");
		}
		System.out.println();
	}
	
	public static void printLevelOrder(TreeNode root) {
		if(root == null) return;
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(root);		
		while(!q.isEmpty()) {
			LinkedList<TreeNode> parents = q;
			q = new LinkedList<TreeNode>();
			for(TreeNode sibling : parents) {
				System.out.print(sibling.val + ",");
				if(sibling.left != null) q.addLast(sibling.left);
				if(sibling.right != null) q.addLast(sibling.right);
			}
			System.out.println();
		}
	}
}
