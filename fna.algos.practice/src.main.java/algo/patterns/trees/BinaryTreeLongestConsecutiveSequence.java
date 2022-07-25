package algo.patterns.trees;

public class BinaryTreeLongestConsecutiveSequence {

    static int lcs;

    public static int findLongestConsecutiveSequence(TreeNode root) {
        lcs = 0;
        find(root, 0, root.val);
        return lcs;
    }
    
    public static void find(TreeNode root, int count, int target) {
        if(root == null) return;
        
        if(root.val == target) {
            ++count;
        } else {
            count = 1;
        }

        lcs = Math.max(lcs, count);

        find(root.left, count, root.val+1);
        find(root.right, count, root.val+1);
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(6);
        root.left.left = new TreeNode(7);
        
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);

        root.right.right.left.right = new TreeNode(6);
        root.right.right.left.right.right = new TreeNode(7);
        root.right.right.left.right.right.right = new TreeNode(8);
        root.right.right.left.right.right.right.right = new TreeNode(9);

        
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = getTree();
        System.out.println(findLongestConsecutiveSequence(root));
    }
}
