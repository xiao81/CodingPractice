package LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;



public class ConvertSortedListToBinarySearchTree_109 {
    List<Integer> list;
    //Brute force
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return sortedListToBSTHelper(0, list.size() - 1);
    }
    public TreeNode sortedListToBSTHelper1(int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = sortedListToBSTHelper(start, mid - 1);
        root.right = sortedListToBSTHelper(mid + 1, end);
        return root;
    }


    //Inorder
    ListNode currNode;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        currNode = head;
        return sortedListToBSTHelper(0, count - 1);
    }

    public TreeNode sortedListToBSTHelper(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(start, mid - 1);
        TreeNode root = new TreeNode(currNode.val);
        currNode = currNode.next;
        TreeNode right = sortedListToBSTHelper(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
