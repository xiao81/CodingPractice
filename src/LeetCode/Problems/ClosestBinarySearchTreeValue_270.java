package LeetCode.Problems;

public class ClosestBinarySearchTreeValue_270 {

    public int closestValue(TreeNode root, double target) {
        TreeNode child = target < root.val ? root.left : root.right;
        if (child == null) return root.val;
        int childValue = closestValue(child, target);
        return Math.abs(root.val - target) > Math.abs(childValue - target) ? root.val : childValue;
    }
}
