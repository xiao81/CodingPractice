package LeetCode.WeeklyContest;

import java.util.*;

public class WeeklyContest44 {
    public static void main(String[] args) {
        WeeklyContest44 weeklyContest44 = new WeeklyContest44();
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (map.get(root.val) != null) {
            return true;
        } else {
            map.put(k-root.val, root.val);
        }
        boolean left = findTarget(root.left, k);
        boolean right = findTarget(root.right, k);
        return left || right;
    }

    int[] numsArr;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        numsArr = nums;
        return constructMaximumBinaryTreeHelper(0, nums.length - 1);
    }
    public TreeNode constructMaximumBinaryTreeHelper(int left, int right) {
        if (left > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int newPivot = left;
        for (int i = left; i <= right; i++) {
            if (numsArr[i] > max) {
                max = numsArr[i];
                newPivot = i;
            }
        }
        TreeNode root = new TreeNode(numsArr[newPivot]);
        root.left = constructMaximumBinaryTreeHelper(left, newPivot - 1);
        root.right = constructMaximumBinaryTreeHelper(newPivot + 1, right);
        return root;
    }

    private List<List<String>> matrix;
    private Queue<String> serializedTree;
    private Queue<TreeNode> queue;
    private int depth = 0;
    public List<List<String>> printTree(TreeNode root) {
        matrix = new LinkedList<>();
        serializedTree = new LinkedList<>();
        queue = new LinkedList<>();
        depth = getDepth(root);
        serializedTree(root);
        initializeMatrix();
        printTreeInMatrix(0, matrix.get(0).size(), 0);
        return matrix;
    }

    private void serializedTree(TreeNode root) {
        queue.offer(root);
        while (!queue.isEmpty()) {
             TreeNode currNode = queue.poll();
             if (currNode != null) {
                 serializedTree.offer("\"" + Integer.toString(currNode.val) + "\"");
                 queue.add(currNode.left);
                 queue.add(currNode.right);
             } else {
                 serializedTree.offer("");
             }
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }

    private void initializeMatrix() {
        for (int i = 0; i < depth; i++) {
            List<String> list = new LinkedList<>();
            for (int j = 0; j < Math.pow(2, depth) - 1; j++) {
                list.add("");
            }
            matrix.add(list);
        }
    }
    private void printTreeInMatrix(int left, int right, int row) {
        if (left > right) return;
        int col = (left + right) / 2;
        matrix.get(row).set(col, serializedTree.poll());
        printTreeInMatrix(left, col - 1, row + 1);
        printTreeInMatrix(col + 1, right, row + 1);
    }
}
