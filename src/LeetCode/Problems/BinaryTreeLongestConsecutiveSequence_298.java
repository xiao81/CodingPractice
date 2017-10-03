package LeetCode.Problems;

public class BinaryTreeLongestConsecutiveSequence_298 {
    private int result = 0;
    public int longestConsecutive(TreeNode root) {
        longestConsecutiveHelper(root);
        return result;
    }

    private int longestConsecutiveHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int path = 1;
        if (root.left != null) {
            int left = longestConsecutiveHelper(root.left);
            if (root.left.val - root.val == 1) path = left + 1;
        }
        if (root.right != null) {
            int right = longestConsecutiveHelper(root.right);
            if (root.right.val - root.val == 1) path = Math.max(path, right + 1);
        }
        result = Math.max(result, path);
        return path;
    }
}
