package LeetCode;

public class PathSum_112 {
    private boolean result = false;
    private int sum;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        hasPathSumHelper(root, 0);
        return result;
    }

    private void hasPathSumHelper(TreeNode root, int count) {
        if (root == null) {
            return;
        }
        count += root.val;
        if (root.left != null && root.right != null) {
            if (count == sum) {
                result = true;
            }
        }
        hasPathSumHelper(root.left, count);
        hasPathSumHelper(root.right, count);
    }
}
