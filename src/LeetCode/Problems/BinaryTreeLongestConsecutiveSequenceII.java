package LeetCode.Problems;

public class BinaryTreeLongestConsecutiveSequenceII {
    private int result = 0;
    public int longestConsecutive(TreeNode root) {
        longestConsecutiveHelper(root);
        return result;
    }
    class ResultType {
        int inc;
        int dec;
        ResultType (int inc, int dec) {
            this.inc = inc;
            this.dec = dec;
        }
    }
    private ResultType longestConsecutiveHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        int inc = 1, dec = 1;
        if (root.left != null) {
            ResultType left = longestConsecutiveHelper(root.left);
            if (root.val - root.left.val == 1) inc = left.inc + 1;
            if (root.val - root.left.val == -1) dec = left.dec + 1;
        }
        if (root.right != null) {
            ResultType right = longestConsecutiveHelper(root.right);
            if (root.val - root.right.val == 1) inc = Math.max(inc, right.inc + 1);
            if (root.val - root.right.val == -1) dec = Math.max(dec, right.dec + 1);
        }
        result = Math.max(result, inc + dec - 1);

        return new ResultType(inc, dec);
    }
}
