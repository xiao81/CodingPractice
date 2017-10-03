package LeetCode.Problems;

import java.util.List;

public class MergeTwoSortedLists_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                if (head != null){
                    curr.next = curr1;
                    curr = curr.next;
                } else {
                    head = curr1;
                    curr = head;
                }
                curr1 = curr1.next;
            } else {
                if (head != null){
                    curr.next = curr2;
                    curr = curr.next;
                } else {
                    head = curr2;
                    curr = head;
                }
                curr2 = curr2.next;
            }
        }
        while (curr1 != null) {
            if (head != null){
                curr.next = curr1;
                curr = curr.next;
            } else {
                head = curr1;
                curr = head;
            }
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            if (head != null) {
                curr.next = curr2;
                curr = curr.next;
            } else {
                head = curr2;
                curr = head;
            }
            curr2 = curr2.next;
        }

        return head;
    }
}
