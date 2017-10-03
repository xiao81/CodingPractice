package LeetCode.Problems;

public class IntersectionOfTwoLinkedLists_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //Find lenght difference
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null) {
            lengthA++;
            currA = currA.next;
        }
        while (currB != null) {
            lengthB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;
        while (lengthA != 0 && lengthB != 0) {
            if (lengthA > lengthB) {
                currA = currA.next;
                lengthA--;
            } else if (lengthB > lengthA) {
                currB = currB.next;
                lengthB--;
            } else {
                if (currA == currB) return currA;
                else return null;
            }
        }
        return null;
    }

    //Two pointers without knowing th length
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return headA;
    }
}
