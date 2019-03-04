package common.utils;

import java.util.Deque;
import java.util.LinkedList;

import common.utils.TreeNode;

public class TreeUtil {
	public static void print(TreeNode root) {
		if(root ==  null) return;
		
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(q.size() > 0) {
			int size = q.size();
			for(int i = 0; i < size; ++i) {
				TreeNode n = q.remove();
				System.out.print(n.val + ",");
				if(n.left != null) q.add(n.left);
				if(n.right != null) q.add(n.right);
			}
			System.out.println();
		}
	}
}
