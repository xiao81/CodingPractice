package LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree_545 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return result;
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        findBoundary(root, true, 0);
        findLeafNodes(root);
        int index = result.size();
        findBoundary(root, false, index);

        return result;
    }

    private void findLeafNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        findLeafNodes(root.left);
        findLeafNodes(root.right);
    }

    private void findBoundary(TreeNode root, boolean dir, int index) {
        TreeNode curr = dir ? root.left : root.right;
        while (curr != null) {
            if (dir) {
                if (curr.left != null) {
                    result.add(curr.val);
                    curr = curr.left;
                } else if (curr.right != null){
                    result.add(curr.val);
                    curr = curr.right;
                } else {
                    break;
                }
            } else {
                if (curr.right != null) {
                    result.add(index, curr.val);
                    curr = curr.right;
                } else if (curr.left != null){
                    result.add(index, curr.val);
                    curr = curr.left;
                } else {
                    break;
                }
            }


        }
    }
}
