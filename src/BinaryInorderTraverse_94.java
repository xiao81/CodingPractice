import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoxiao on 5/23/17.
 */
public class BinaryInorderTraverse_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHelper(root);
        return list;
    }
    private void inorderTraversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalHelper(root.left);
        list.add(root.val);
        inorderTraversalHelper(root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode currNode = root;
        while(currNode != null || !stack.isEmpty()) {
            while(currNode!= null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            list.add(currNode.val);
            currNode = currNode.right;
        }
        return list;
    }

}
