package Assignments;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public String toString() {
        String result = "";
        ListNode curr = this;
        while(curr != null){
            result += curr.val + "->";
            curr = curr.next;
        }
        return result + "NULL";
    }
}
