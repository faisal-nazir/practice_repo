package pc.ds.trees;

import common.utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
**/

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
public class SerializeTree {

	private static final String splitter = ",";
	private static final String NN = "#";
	
	public static String serialize(TreeNode root) {
		if(root == null) return NN;
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	
	// changing it to pre-order
	public static void serialize(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append(NN).append(splitter);
		} else {
			sb.append(root.val).append(splitter);
			serialize(root.left, sb);
//				sb.append(root.value).append(splitter);
			serialize(root.right, sb);
		}
	}
	
	// in-order strategy doesn't work (why??)
	public static TreeNode deSerialize(String s) {
		if(s == null || s.isEmpty()) return null;
		String[] arr = s.split(splitter);
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(arr));
//		return deSerialize(arr, 0, arr.length -1);
		return deSerialize(nodes);
	}
	
//	public static TreeNode deSerialize(String[] arr, int start, int end) {
//		if (start > end) 
//			return null;
//		int mid = (start + end) >>> 1;
//		if (arr[mid].equals(NN))
//			return null;
//		else {
//			TreeNode root = new TreeNode(Integer.parseInt(arr[mid]));
//			root.left = deSerialize(arr, start, mid - 1);
//			root.right = deSerialize(arr, mid + 1, end);
//			return root;
//		}
//	}
	
	public static TreeNode deSerialize(Deque<String> q) {
		String s = q.removeFirst();
		if(s.equals(NN))
			return null;
		else {
			TreeNode root = new TreeNode(Integer.parseInt(s));
			root.left = deSerialize(q);
			root.right = deSerialize(q);
			return root;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
//		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		print(root);
		String s = serialize(root);
		System.out.println(s);
		TreeNode result = deSerialize(s);
		print(result);
	}
	
	public static void print(TreeNode root) {
		if(root == null) return;
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		while(!q.isEmpty()) {
			Deque<TreeNode> parents = q;
			q = new LinkedList<TreeNode>();
			for(TreeNode parent: parents) {
				System.out.print(parent.val + splitter);
				if(parent.left != null) q.addLast(parent.left);
				if(parent.right != null) q.addLast(parent.right);
			}
			System.out.println();
		}
		
	}
	
	
}
