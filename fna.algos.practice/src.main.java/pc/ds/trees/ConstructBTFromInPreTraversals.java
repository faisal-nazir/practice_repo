package pc.ds.trees;

import java.util.HashMap;
import java.util.Map;

import common.utils.TreeNode;

/** Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
**/
public class ConstructBTFromInPreTraversals {

	// From Laiq's LeetCode submission
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; ++i)
            inOrderMap.put(inorder[i], i);
            
        return buildTree(preorder, inOrderMap, 0, preorder.length - 1, 0);
    }
    
    public static TreeNode buildTree(int[] preOrder, Map<Integer, Integer> inOrderMap, int start, int end, int preIndex) {
        if(start > end) return null;
        if(start == end)    return new TreeNode(preOrder[preIndex]);
        int iIndex = inOrderMap.get(preOrder[preIndex]);
        
        TreeNode root = new TreeNode(preOrder[preIndex]);
        root.left = buildTree(preOrder, inOrderMap, start, iIndex - 1, preIndex + 1);
        root.right= buildTree(preOrder, inOrderMap, iIndex + 1, end, preIndex + (iIndex - start + 1));
        return root;
    }
}
