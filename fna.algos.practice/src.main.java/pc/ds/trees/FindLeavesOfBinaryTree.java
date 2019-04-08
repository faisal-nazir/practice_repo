package pc.ds.trees;

import common.utils.TreeNode;
import java.util.List;
import java.util.ArrayList;

/** Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
 *  repeat until the tree is empty.

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]
 

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          
 

2. Now removing the leaf [2] would result in this tree:

          1          
 

3. Now removing the leaf [1] would result in the empty tree:

          []     
**/
public class FindLeavesOfBinaryTree {
	
	// https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778/10-lines-simple-Java-solution-using-recursion-with-explanation
	public static List<List<Integer>> findLeaves(TreeNode root) {
		if(root == null) return null;
		List<List<Integer>> result = new ArrayList<>();
		height(root, result);
		return result;
	}
	
	public static int height(TreeNode n, List<List<Integer>> lists) {
		if(n == null) return -1;
		int h = Math.max(height(n.left, lists), height(n.right, lists)) + 1;
		if(h >= lists.size())
			lists.add(new ArrayList<Integer>());
		
		lists.get(h).add(n.val);
		return h;
	}
	
	public static void main(String[] args) {
		TreeNode root = createNewTree();
		List<List<Integer>> lists = findLeaves(root);
		print(lists);
	}
	
	public static TreeNode createNewTree() {
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);;
		root.left.right.left = new TreeNode(3);
		
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(8);
		
		return root;
	}
	
	public static void print(List<List<Integer>> lists) {
		for(List<Integer> list : lists) {
			System.out.print("{");
			for(Integer i : list) {
				System.out.print(i + ", ");
			}
			System.out.print("} ");
		}
	}
}
