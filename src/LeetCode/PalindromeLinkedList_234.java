package LeetCode;

import jdk.internal.util.xml.impl.Pair;

import java.util.Stack;

public class PalindromeLinkedList_234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        int lenght = 0;
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            lenght++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < lenght/2; i++) {
            stack.add(curr.val);
            curr = curr.next;
        }
        if (lenght % 2 != 0) {
            stack.add(curr.val);
        }
        for (int i = lenght/2; i < lenght; i++) {
            if (stack.pop() != curr.val) return false;
            curr = curr.next;
        }
        return true;

    }
}
