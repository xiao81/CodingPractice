package LeetCode.WeeklyContest;


public class WeeklyContest48 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        int left = findSecondMinimumValue(root.left);
        int right = findSecondMinimumValue(root.right);

        if (left == -1 && right == -1) return root.val;
        else if (left == -1 && right != root.val) return right;
        else if (right == -1 && left != root.val) return left;
        else if (left == root.val && right == root.val) return  -1;
        else if (left != root.val && (left <= right || right == root.val)) return left;
        else if (right != root.val && (right <= left || left == root.val)) return right;
        else return -1;
    }
}
