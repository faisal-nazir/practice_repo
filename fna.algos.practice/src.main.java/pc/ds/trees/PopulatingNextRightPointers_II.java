package pc.ds.trees;

/** Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
**/

public class PopulatingNextRightPointers_II {
	
	/** Given the following binary tree,
	
		    1
		  /  \
		 2    3
		/ \    \
		4   5    7
	After calling your function, the tree should look like:
		
		    1 -> NULL
		  /  \
		 2 -> 3 -> NULL
		/ \    \
		4-> 5 -> 7 -> NULL
	**/ 
	
	public static class LinkTreeNode {
		LinkTreeNode left;
		LinkTreeNode right;
		LinkTreeNode next;
		int val;
		
		public LinkTreeNode(int value) {
			this.val = value;
		}
	}

	//based on level order traversal
    public void connect(LinkTreeNode root) {

    	LinkTreeNode head = null; //head of the next level
    	LinkTreeNode prev = null; //the leading node on the next level
    	LinkTreeNode cur = root;  //current node of current level

        while (cur != null) {
            
            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }
            
            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        
    }
}
