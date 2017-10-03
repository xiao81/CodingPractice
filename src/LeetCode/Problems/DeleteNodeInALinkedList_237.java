package LeetCode.Problems;

public class DeleteNodeInALinkedList_237 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode currNode = node;
        while (currNode.next != null) {
            if (currNode.next.next == null) {
                currNode.val = currNode.next.val;
                currNode.next = null;
                return;
            }
            currNode.val = currNode.next.val;
            currNode = currNode.next;
        }

    }
    public void deleteNode1(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
