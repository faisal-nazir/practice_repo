package algo.patterns.trees;

public class BinaryTreeMaximumPathSum {

	static int max = Integer.MIN_VALUE;
    
    public static int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }
    
    public static int find(TreeNode root) {
        if(root == null) return 0;
        
        int left = find(root.left);
        int right = find(root.right);
        
        int sum = left + root.val + right;
        max = Math.max(max, sum);
        
        return (sum < 0) ? 0 : Math.max(left, right) + root.val;
    }

    private static TreeNode getTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = getTree();
        System.out.println(maxPathSum(root));
    }
}
