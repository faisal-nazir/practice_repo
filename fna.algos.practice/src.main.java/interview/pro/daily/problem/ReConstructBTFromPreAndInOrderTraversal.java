package interview.pro.daily.problem;

import java.util.*;

public class ReConstructBTFromPreAndInOrderTraversal {

	private static class Node {
		String value;
		Node left;
		Node right;
		
		Node(String val) {
			value = val;
		}
	}
	
	public static Node construct(List<String> preOrder, List<String> inOrder) {
		Map<String, Integer> in_map = new HashMap<>();
		for(int i = 0; i < inOrder.size(); ++i) {
			in_map.put(inOrder.get(i), i);
		}
		return helper(preOrder, 0, preOrder.size()-1, in_map, 0);
	}
	
	private static Node helper(List<String> preOrder, int s, int e, Map<String, Integer> in_map, int idx) {
		if(s > e) return null;
		
		int in_index = in_map.get(preOrder.get(idx));
				
		System.out.println("s =" + s + " , " + "e =" + e + " , " + "idx =" + idx + " , " + "in_idx =" + in_index + " , " + "value =" + preOrder.get(idx));
		
		Node root = new Node(preOrder.get(idx));
		root.left = helper(preOrder, s, in_index-1, in_map, idx+1);
		root.right= helper(preOrder, in_index+1, e, in_map, idx + (in_index+1) - s);
		
		return root;
	}
	
	public static void main(String[] args) {
		//Preorder: [a, b, d, e, c, f, g]
		//Inorder: [d, b, e, a, f, c, g]
		List<String> inOrder = Arrays.asList("d", "b", "e", "a", "f", "c", "g");
		List<String> preOrder = Arrays.asList("a", "b", "d", "e", "c", "f", "g");
		construct(preOrder, inOrder);
	}
	
	private static void print(Node n) {
		if(n == null) return;
		Deque<Node> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				Node curr = q.poll();
				System.out.print(curr.value + " ");
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
			System.out.println();
		}
	}
}
