package LeetCode.Problems;

public class SubtreeOfAnotherTree_572 {
    private TreeNode t;
    private boolean result = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        this.t = t;
        preOrder(s);
        return result;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == t.val) {
            if (result == false) {
                result = compareTree(root, t);
            }
        }
        preOrder(root.left);
        preOrder(root.right);
    }

    private boolean compareTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return compareTree(root1.left, root2.left) && compareTree(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
