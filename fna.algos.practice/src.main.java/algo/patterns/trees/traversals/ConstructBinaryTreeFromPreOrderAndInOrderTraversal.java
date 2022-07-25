package algo.patterns.trees.traversals;

import java.util.*;
import algo.patterns.trees.TreeNode;

public class ConstructBinaryTreeFromPreOrderAndInOrderTraversal {

	int pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        pre = 0;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1, map);
    }
    
    private TreeNode helper(int[] preorder, int start, int end, Map<Integer, Integer> map) {
        if(start > end) return null;
        
        TreeNode root = new TreeNode(preorder[pre++]);
        int pos = map.get(root.val);
        root.left = helper(preorder, start, pos-1, map);
        root.right = helper(preorder, pos+1, end, map);
        
        return root;
    }
}
