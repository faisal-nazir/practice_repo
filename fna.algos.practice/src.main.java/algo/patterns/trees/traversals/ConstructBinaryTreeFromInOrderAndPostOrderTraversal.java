package algo.patterns.trees.traversals;

import java.util.*;
import algo.patterns.trees.TreeNode;

public class ConstructBinaryTreeFromInOrderAndPostOrderTraversal {

	int post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        post = postorder.length-1;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1, map);
    }
    
    private TreeNode helper(int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if(start > end) return null;
        
        TreeNode root = new TreeNode(postorder[post--]);
        int pos = map.get(root.val);
        root.right = helper(postorder, pos+1, end, map); 
        root.left = helper(postorder, start, pos-1, map);
        
        return root;
    }
}
