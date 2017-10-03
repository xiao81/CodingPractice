package LeetCode.Problems;

public class RemoveLinkedListElements_203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.next != null) {
            if (curr.val == val) {
                curr.val = curr.next.val;
                curr.next = curr.next.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        if (curr != null && curr.val == val) {
            if (prev == null) {
                return null;
            } else {
                prev.next = null;
            }
        }
        return head;
    }
}
