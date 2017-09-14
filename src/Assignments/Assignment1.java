package Assignments;

import jdk.internal.util.xml.impl.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Assignment1 {
    public static void main(String[] args) {

    }

    //LinkedList
    //Q1 Stack
    public ListNode reverseKGroup(ListNode head, int k) {

        Stack<Integer> stack = new Stack<>();
        ListNode currNode = head;
        ListNode resultHead = null;
        ListNode resultCurrNode = resultHead;
        int count = 0;
        while (currNode != null) {
            stack.push(currNode.val);
            currNode = currNode.next;
            count++;
            if (count == k) {
                count = 0;
                while (!stack.isEmpty()) {
                    int value = stack.pop();
                    if (resultHead == null) {
                        resultHead = new ListNode(value);
                        resultCurrNode = resultHead;
                    } else {
                        resultCurrNode.next = new ListNode(value);
                        resultCurrNode = resultCurrNode.next;
                    }
                }
            }
        }

        return resultHead;
    }

    //Q1 Inplace
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode startNode = head;
        ListNode currNode = head;
        ListNode nextNode;
        ListNode prevNode;
        ListNode resultHead = new ListNode(0);
        prevNode = resultHead;
        int count = 0;
        while (currNode != null) {
            count++;
            nextNode = currNode.next;
            currNode = currNode.next;
            if (count == k || currNode == null) {
                prevNode.next = reverseKGroup2Helper(startNode, k);
                startNode.next = nextNode;
                prevNode = startNode;
                startNode = startNode.next;
                count = 1;
            }
        }
        return resultHead.next;
    }
    public ListNode reverseKGroup2Helper(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (k != 0 && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

    //Q2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode head = null;
        while (curr1 != null) {
            stack1.push(curr1.val);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            stack2.push(curr2.val);
            curr2 = curr2.next;
        }
        int value = 0;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                value = stack1.pop() + stack2.pop() + carry;
            } else if (!stack1.isEmpty()) {
                value = stack1.pop() + carry;
            } else {
                value = stack2.pop() + carry;
            }
            carry = value / 10;
            value %= 10;
            ListNode digitNode = new ListNode(value);
            digitNode.next = head;
            head = digitNode;
        }
        if (carry != 0) {
            ListNode digitNode = new ListNode(carry);
            digitNode.next = head;
            head = digitNode;
        }

        return head;
    }

    //Q3 Without return the joint
    public boolean checkLoopInList1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    //Q3 Return the joint
    public ListNode checkLoopInList2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //Q4
    public boolean checkPalindromeInList(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Odd case
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);

        while (slow != null) {
            if (slow.val != curr.val) return false;
            slow = slow.next;
            curr = curr.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Q5
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        //Redirect the list to the other if reach to the end of the list
        //It will make sure both lists eventually move to the intersection at the same time
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }

    //Tree
    //Q1
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resultList = new LinkedList<>();

        if (root == null) return resultList;

        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> levelList= new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
                levelList.add(currNode.val);
            }
            resultList.add(levelList);
        }
        return resultList;
    }

    //Q2
    //Since i am using LeetCode No.103 to test my code. I change the spiral order to be
    //Odd level: left to right
    //Even level: right to left
    public List<List<Integer>> spiralOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resultList = new LinkedList<>();
        if (root == null) return resultList;

        int count = 1;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> levelList= new LinkedList<>();
            if (count % 2 == 0) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < queueSize; i++) {
                    TreeNode currNode = queue.poll();
                    if (count % 2 == 0) stack.push(currNode.val);
                    if (currNode.left != null) queue.offer(currNode.left);
                    if (currNode.right != null) queue.offer(currNode.right);
                }
                while(!stack.isEmpty()) {
                    levelList.add(stack.pop());
                }
            } else {
                for (int i = 0; i < queueSize; i++) {
                    TreeNode currNode = queue.poll();
                    levelList.add(currNode.val);
                    if (currNode.left != null) queue.offer(currNode.left);
                    if (currNode.right != null) queue.offer(currNode.right);
                }
            }
            count++;
            resultList.add(levelList);

        }
        return resultList;
    }

    //Q3
    //Inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> inorderStack = new Stack<>();
        List<Integer> resultList = new LinkedList<>();
        if (root == null) return resultList;
        TreeNode currNode = root;
        while (!inorderStack.isEmpty() || currNode != null) {
            if (currNode != null) {
                inorderStack.push(currNode);
                currNode = currNode.left;
            } else{
                currNode = inorderStack.pop();
                resultList.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return resultList;
    }

    //preOrder
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> preOrderStack = new Stack<>();
        List<Integer> resultList = new LinkedList<>();
        if (root == null) return resultList;
        TreeNode currNode = root;
        while(!preOrderStack.isEmpty() || currNode != null) {
            if (currNode != null) {
                resultList.add(currNode.val);
                preOrderStack.push(currNode);
                currNode = currNode.left;
            } else {
                currNode = preOrderStack.pop();
                currNode = currNode.right;
            }

        }
        return resultList;
    }

    //postOrder
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> postOrderStack = new Stack<>();
        List<Integer> resultList = new LinkedList<>();
        TreeNode currNode = root;
        if (root == null) return resultList;
        while (!postOrderStack.isEmpty() || currNode != null) {
            if (currNode != null) {
                resultList.add(0, currNode.val);
                postOrderStack.push(currNode);
                currNode = currNode.right;
            } else {
                currNode = postOrderStack.pop();
                currNode = currNode.left;
            }
        }
        return resultList;
    }

    //Q4
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //Q5

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (root == p || root == q) return root;
        else return left == null ? right : left;
    }





































}
