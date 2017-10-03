package LeetCode.Problems;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal_105 constructBinaryTreeFromPreorderAndInorderTraversal_105 = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();
        constructBinaryTreeFromPreorderAndInorderTraversal_105.buildTree(new int[]{1,2,7,9,8,12,3,13,3,20,4,6,5}, new int[]{9,7,8,2,3,12,13,1,4,20,3,6,5});
    }

    private int[] preOrder;
    private int[] inOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        preOrder = preorder;
        inOrder = inorder;
        return buildTreeHelper(0, 0, inorder.length - 1);
    }
    private TreeNode buildTreeHelper(int pivot, int start, int end) {
        if (pivot > preOrder.length - 1 || start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[pivot]);
        int i;
        for (i = start; i <= end; i++) {
            if (inOrder[i] == preOrder[pivot]) break;
        }
        root.left = buildTreeHelper(pivot + 1, start, i - 1);
        root.right = buildTreeHelper(pivot + i - start + 1, i + 1, end);
        return root;
    }
}
