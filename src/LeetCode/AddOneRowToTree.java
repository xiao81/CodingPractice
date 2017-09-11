package LeetCode;

public class AddOneRowToTree {
    private int depth = 0;
    private int value = 0;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        depth = d;
        value = v;
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(value);
            newRoot.left = root;
            return newRoot;
        }
        addOneRowHelper(root, 1);
        return root;
    }
    private void addOneRowHelper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth + 1 == this.depth) {
            if (root.left != null) {
                TreeNode rootChild = new TreeNode(value);
                rootChild.left = root.left;
                root.left = rootChild;
            }
            if (root.right != null) {
                TreeNode rootChild = new TreeNode(value);
                rootChild.right = root.right;
                root.right = rootChild;
            }
            if (root.left == null) {
                TreeNode rootChild = new TreeNode(value);
                root.left = rootChild;
            }
            if (root.right == null) {
                TreeNode rootChild = new TreeNode(value);
                root.right = rootChild;
            }

        }
        addOneRowHelper(root.left, depth+1);
        addOneRowHelper(root.right, depth+1);
    }

}
