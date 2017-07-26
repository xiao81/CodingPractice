package LeetCode;

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        ResultType result = isBalancedHelper(root);
        return result.isBalanced;
    }

    class ResultType {
        int height;
        boolean isBalanced;
        ResultType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    private ResultType isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        ResultType left = isBalancedHelper(root.left);
        ResultType right = isBalancedHelper(root.right);
        return new ResultType(Math.max(left.height, right.height) + 1, Math.abs(left.height - right.height) <= 1 && left.isBalanced && right.isBalanced);
    }
}
