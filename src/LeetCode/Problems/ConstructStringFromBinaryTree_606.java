package LeetCode.Problems;

public class ConstructStringFromBinaryTree_606 {
    private StringBuffer sb = new StringBuffer();
    public String tree2str(TreeNode t) {
        preOrder(t);
        return sb.substring(1,sb.length()-1);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            sb.append("()");
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if (root.left == null && root.right != null || root.left != null && root.right != null) {
            preOrder(root.left);
            preOrder(root.right);
        } else if (root.left != null && root.right == null) {
            preOrder(root.left);
        }
        sb.append(")");
    }
}
