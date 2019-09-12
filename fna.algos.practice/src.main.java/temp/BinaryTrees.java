package temp;


import java.util.*;

public class BinaryTrees {

	private static int node_num = 0;

	public static List<Node<Integer>> getAllBinaryTrees(int noOfNodes) {
		List<Node<Integer>> trees = new ArrayList<>();
		if(noOfNodes == 0) {
			trees.add(null);
		}

		for(int idx_left = 0; idx_left < noOfNodes; ++idx_left) {
			int idx_right = noOfNodes-idx_left-1;
			List<Node<Integer>> left_SubTrees = getAllBinaryTrees(idx_left);
			List<Node<Integer>> right_SubTrees = getAllBinaryTrees(idx_right);

			for(Node<Integer> left : left_SubTrees) {
				for(Node<Integer> right: right_SubTrees) {
					Node<Integer> root = new Node<Integer>(node_num++, left, right);
					trees.add(root);
				}
			}
		}

		return trees;
	}

	private static class Node<T> {
		T val;
		Node<T> left;
		Node<T> right;

		Node(T val) {
			this.val = val;
		}

		Node(T val, Node<T> left, Node<T> right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		int num = 3;
		List<Node<Integer>> res = getAllBinaryTrees(num);
		print(res);

		//Node<Integer> root = createTree();
		//print(root);
	}

	private static void print(List<Node<Integer>> trees) {
		int num = 1;
		System.out.println("========== Start ============");
		for(Node<Integer> root : trees) {
			System.out.println("========== Start Tree # " +num+ " ============");
			print(root);
			System.out.println("========== End Tree # " +num+ " ============");
			++num;
		}
		System.out.println("========== End ============");
	}

	private static void print(Node<Integer> root) {
		if(root == null) return;
		Node<Integer> itr =  root;
		Deque<Node<Integer>> q = new LinkedList<Node<Integer>>();
		q.addLast(itr);
		while(!q.isEmpty()) {
			int n = q.size();
			Deque<Node<Integer>> child = new LinkedList<Node<Integer>>();
			for(int i = 0; i < n; ++i) {
				Node<Integer> node = q.removeFirst();
				if(node.left != null) 
					child.addLast(node.left);
				if(node.right != null) 
					child.addLast(node.right);
				System.out.print(node.val + " ");
			}
			q = child;
			System.out.println();
		}
	}	

	private static Node<Integer> createTree() {
		Node<Integer> root = new Node<Integer>(0);
		root.left = new Node<Integer>(1);
		root.right = new Node<Integer>(2);
		root.left.left = new Node<Integer>(3);
		root.left.right = new Node<Integer>(4);
		root.right.left = new Node<Integer>(5);
		root.right.right = new Node<Integer>(6);
		return root;
	}
}

