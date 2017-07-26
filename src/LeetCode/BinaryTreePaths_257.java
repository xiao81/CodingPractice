package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths_257 {
    private List<String> paths = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsHelper(root, "");
        return paths;
    }

    private void binaryTreePathsHelper(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path +=root.val+"->";
        if (root.left != null) {
            binaryTreePathsHelper(root.left, path);
        }
        if (root.right != null) {
            binaryTreePathsHelper(root.right, path);
        }
        if (root.left == null && root.right == null) {
            paths.add(path.substring(0,path.length()-2));
        }
    }
}
