package interview.pro.daily.problem;

import java.util.*;

public class SerializeBinaryTree {
	
	private static final String SPLITTER = ",";
	private static final String NN = "#";

	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int val) {
			this.value = val;
		}
	}
	
	public static String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	
	private static void serialize(Node root, StringBuilder sb) {
		if(root == null) {
			sb.append(NN).append(SPLITTER);
		} else {
			sb.append(root.value).append(SPLITTER);
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}
	
	public static Node deserialize(String str) {
		String[] nodes = str.split(SPLITTER);
		Deque<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(nodes));
		
		return deserialize(q);
	}
	
	private static Node deserialize(Deque<String> q) {
		String curr = q.poll();
		if(curr.equals(NN)) {
			return null;
		} else {
			Node n = new Node(Integer.parseInt(curr));
			n.left = deserialize(q);
			n.right = deserialize(q);
			return n;
		}
	}
	
	public static void main(String[] args) {
		Node root = getTree();
		String str = serialize(root);
		System.out.println(str);
		Node res = deserialize(str);
		print(res);
	}
	
	private static void print(Node n) {
		if(n != null) {
			print(n.left);
			System.out.print(n.value + " ");
			print(n.right);
		}
	}
	
	private static Node getTree() {
		Node n = new Node(2);
		n.left = new Node(1);
		n.right = new Node(6);
		
		n.left.left = new Node(3);
		n.left.right = new Node(4);
		
		n.right.left = new Node(7);
		n.right.right = new Node(8);
		
		return n;
	}
	
	
}
