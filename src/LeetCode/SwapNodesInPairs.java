package LeetCode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode next;
        dummyHead.next = head;
        while (curr != null && curr.next != null) {
            next = curr.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
