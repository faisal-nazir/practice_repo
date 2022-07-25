package algo.patterns.trees;

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode root, int sum) {
        if(root == null) return 0;
        
        sum *= 10;
        sum += root.val;
        
        if(root.left == null && root.right == null) {
            return sum;
        }
        
        int left = sumNumbers(root.left, sum);
        int right = sumNumbers(root.right, sum);
        
        return left + right;
    }
}