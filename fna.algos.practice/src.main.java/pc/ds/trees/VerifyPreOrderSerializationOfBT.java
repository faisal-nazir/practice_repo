package pc.ds.trees;

/** One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
**/
public class VerifyPreOrderSerializationOfBT {

	public static boolean isValidSerialization_01(String preorder) {
		String[] nodes = preorder.split(",");
		int edges = 1;
		for (int i = 0; i < nodes.length; i++) {
			edges--; // consume one edge
			if (edges < 0)
				return false; // to prevent the case: #, a, ...
			if (!nodes[i].equals("#")) {
				edges += 2; // generate 2 edges
			}
		}
		return edges == 0;
	}

	// Thinking of number of leaves expected at each node position,
	// before processing, the tree should have one expected leaf (the root),
	// if a node is not a leaf, then it's a new branch, in BT, the expected
	// leaves should be increased by 1.

	public boolean isValidSerialization_02(String preorder) {
		String[] nodes = preorder.split(",");
		int leaves = 1; // expected number of leaves
		for (String node : nodes) {
			if (leaves <= 0)
				return false;
			if (node.charAt(0) == '#') // a leaf
				leaves--;
			else
				// a new branch
				leaves++;
		}
		return leaves == 0;
	}
}
