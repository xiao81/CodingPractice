package LeetCode.Problems;

public class BinaryTreeTilt_563 {
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        findTiltHelper(root);
        return tilt;
    }
    private int findTiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTiltHelper(root.left);
        int right = findTiltHelper(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
