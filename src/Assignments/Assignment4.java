package Assignments;

import java.util.*;

public class Assignment4 {
    int maxSize;
    public int largestBSTSubtree(TreeNode root) {
        maxSize = 0;
        ResultType result = largestBSTSubtreeHelper(root);
        return Math.max(maxSize, result.size);
    }
    public ResultType largestBSTSubtreeHelper(TreeNode root) {
        if (root == null) return new ResultType(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        ResultType left = largestBSTSubtreeHelper(root.left);
        ResultType right = largestBSTSubtreeHelper(root.right);

        if (left.isValid && right.isValid) {
            if (root.val > left.rightBound && root.val < right.leftBound) {
                int leftBound = root.left == null ? root.val : left.leftBound;
                int rightBound = root.right == null ? root.val : right.rightBound;
                int size = left.size + right.size + 1;
                maxSize = Math.max(size, maxSize);
                return new ResultType(size, true, leftBound, rightBound);
            }
        }

        return new ResultType(0, false,0,0);
    }
    class ResultType {
        int size;
        int leftBound;
        int rightBound;
        boolean isValid;
        ResultType(int size, boolean isValid, int leftBound, int rightBound) {
            this.size = size;
            this.isValid = isValid;
            this.rightBound = rightBound;
            this.leftBound = leftBound;
        }
    }

    //Q2
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTreeHelper(0, 0 ,preorder.length - 1);
    }

    public TreeNode buildTreeHelper (int pivot, int start, int end) {
        if (start > end || pivot < 0 || pivot > preorder.length - 1) return null;
        TreeNode root = new TreeNode(preorder[pivot]);
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == preorder[pivot]) break;
        }
        root.left = buildTreeHelper(pivot + 1, start, i - 1);
        root.right = buildTreeHelper(pivot + i - start + 1, i + 1, end);
        return root;
    }

    //Q3
    //BFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            sb.append(currNode == null ? "n " : currNode.val + " ");
            if (currNode != null) {
                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataList = data.split(" ");
        if (dataList.length < 2) return null;
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i != dataList.length){
            TreeNode currNode = queue.poll();
            if (!dataList[i].equals("n")) {
                currNode.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(currNode.left);
            }
            i++;
            if (!dataList[i].equals("n")) {
                currNode.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(currNode.right);
            }
            i++;
        }
        return root;
    }

    //DFS
    StringBuilder sb;
    public String serialize1(TreeNode root) {
        sb = new StringBuilder();
        serializedHelper(root);
        return sb.substring(0, sb.length() - 1);
    }
    public void serializedHelper(TreeNode root) {
        if (root == null) {
            sb.append("n ");
        } else {
            sb.append(root.val + " ");
            serializedHelper(root.left);
            serializedHelper(root.right);
        }

    }
    Queue<String> dataList;
    public TreeNode deserialize1(String data) {
        dataList = new LinkedList<>();
        dataList.addAll(Arrays.asList(data.split(" ")));
        if (dataList.size() < 2) return null;
        return deserializeHelper();
    }

    public TreeNode deserializeHelper() {
        String val = dataList.poll();
        if (val.equals("n")) return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserializeHelper();
            root.right = deserializeHelper();
            return root;
        }
    }

    //Q4
    public TreeNode deleteNode(TreeNode root, int[] range) {
        if(root == null){
            return null;
        }
        root.left = deleteNode(root.left, range);
        root.right = deleteNode(root.right, range);
        if (root.val >= range[0] && root.val <= range[1]) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right, range);
            root.val = minNode.val;
            root.right = deleteNode(root.right, range);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node, int[] range){
        while(node.left != null){
            if (node.left.val >= range[0] && node.left.val <= range[1]) {
                node = node.left;
            } else {
                return node;
            }
        }
        return node;
    }

    //Q5
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode curr = levelStart;
            while (curr != null) {
                if (curr.left != null) curr.left.next = curr.right;
                if (curr.right != null && curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }

}
