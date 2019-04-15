package pc.ds.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.utils.TreeNode;


/** Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
**/

public class UniqueBSTs_II {

	// https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution
	
	// I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n. 
	// So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1), 
	// and the right subtree will contain elements (i+1) to n.
	// I use recursive calls to get back all possible trees for left and right subtrees and
	// combine them in all possible ways with the root.
	
	public List<TreeNode> generateTrees(int n) {

		return genTrees(1, n);
	}

	public List<TreeNode> genTrees(int start, int end) {

		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start > end) {
			list.add(null);
			return list;
		}

		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		List<TreeNode> left, right;
		for (int i = start; i <= end; i++) {

			left = genTrees(start, i - 1);
			right = genTrees(i + 1, end);

			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					list.add(root);
				}
			}

		}

		return list;
	}
	
	public static void main(String[] args) {
		UniqueBSTs_II s = new UniqueBSTs_II();
		List<TreeNode> result =  s.generateTrees(3);
		for(TreeNode t : result) {
			print(t);
			System.out.println("------------------");
		}
	}
	
	public static void print(TreeNode root) {
		if(root == null) return;
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.addLast(root);
		while(!q.isEmpty()) {
			Deque<TreeNode> parents = q;
			q = new LinkedList<TreeNode>();
			for(TreeNode parent: parents) {
				System.out.print(parent.val + ",");
				if(parent.left != null) q.addLast(parent.left);
				if(parent.right != null) q.addLast(parent.right);
			}
			System.out.println();
		}
		
	}
}
