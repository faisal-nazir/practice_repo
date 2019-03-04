package pc.ds.trees.traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.utils.TreeNode;
/**	Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/
public class LevelOrderTraversal_II {

	// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/34981/My-DFS-and-BFS-java-solution
	public List<List<Integer>> levelOrderBottom_BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
            	TreeNode top = queue.peek();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList); // Add the newly discovered to the start of result list
        }
        return wrapList;
    }
	
	// DFS - version
    public List<List<Integer>> levelOrderBottom_DFS(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>()); // when explore a new bottom, add it to the start of result list.
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val); // because lists are added in reverse therefore we need to compute the index instead of using 'level' variable
    }

}
