package LeetCode.Problems;

import jdk.internal.util.xml.impl.Pair;

public class PlusOneLinkedList_369 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode plusOne(ListNode head) {
        StringBuffer sb = new StringBuffer();
        ListNode resultHead = null;
        ListNode curr = null;
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String result = Long.toString(Long.valueOf(sb.toString()) + 1);
        for (int i = 0; i < result.length(); i++) {
            if (resultHead == null) {
                resultHead = new ListNode(Character.getNumericValue(result.charAt(i)));
                curr = resultHead;
            } else {
                curr.next = new ListNode(Character.getNumericValue(result.charAt(i)));
                curr = curr.next;
            }
        }
        return resultHead;
    }
}
