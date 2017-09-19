package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ArrayList<ListNode> result = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            result.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) result.remove(result.size()-1);
        fast = slow.next;
        slow.next = null;

        for (int i = result.size() - 1; i >= 0; i--) {
            ListNode next = fast;
            ListNode curr = result.get(i);
            fast = fast.next;
            next.next = curr.next;
            curr.next = next;

        }
    }
}
