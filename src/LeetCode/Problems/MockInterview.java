package LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;

public class MockInterview {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHelper(root);
        return result;
    }

    public void inorderTraversalHelper(TreeNode root) {
        if (root == null) return;
        inorderTraversalHelper(root.left);
        result.add(root.val);
        inorderTraversalHelper(root.right);
    }
}
