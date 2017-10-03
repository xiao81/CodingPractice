package Assignments;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment2 {
    //Testing for flatternList
    Node createList(int arr[], int n) {
        Node node = null;
        Node p = null;

        int i;
        for (i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new Node(arr[i]);
            } else {
                p.next = new Node(arr[i]);
                p = p.next;
            }
            p.next = p.child = null;
        }
        return node;
    }

    // A utility function to print all nodes of a linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    Node createList() {
        int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};

        /* create 8 linked lists */
        Node head1 = createList(arr1, arr1.length);
        Node head2 = createList(arr2, arr2.length);
        Node head3 = createList(arr3, arr3.length);
        Node head4 = createList(arr4, arr4.length);
        Node head5 = createList(arr5, arr5.length);
        Node head6 = createList(arr6, arr6.length);
        Node head7 = createList(arr7, arr7.length);
        Node head8 = createList(arr8, arr8.length);

        /* modify child pointers to create the list shown above */
        head1.child = head2;
        head1.next.next.next.child = head3;
        head3.child = head4;
        head4.child = head5;
        head2.next.child = head6;
        head2.next.next.child = head7;
        head7.child = head8;

        /* Return head pointer of first linked list.  Note that all nodes are
         reachable from head1 */
        return head1;
    }
    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        Node head = assignment2.createList();
        assignment2.printList(assignment2.flattenList(head));
    }

    //LinkedList
    //Q1
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode copyedHead = new RandomListNode(head.label);
        RandomListNode copyedCurrNode = copyedHead;
        RandomListNode currNode = head;
        HashMap<RandomListNode, RandomListNode> linkedMap = new HashMap<>();
        linkedMap.put(currNode, copyedCurrNode);
        while (currNode != null && currNode.next != null) {
            copyedCurrNode.next = new RandomListNode(currNode.next.label);
            currNode = currNode.next;
            copyedCurrNode = copyedCurrNode.next;
            linkedMap.put(currNode, copyedCurrNode);
        }

        currNode = head;
        copyedCurrNode = copyedHead;

        while (currNode != null) {
            copyedCurrNode.random = linkedMap.get(currNode.random);
            currNode = currNode.next;
            copyedCurrNode = copyedCurrNode.next;
        }
        return copyedHead;
    }

    //Q2
    //Starting point
    public ListNode findCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //Cycle length
    public int findCycleLength(ListNode head) {
        ListNode startNode = findCycle(head);
        ListNode currNode = startNode.next;
        int length = 1;
        while (currNode != startNode) {
            currNode = currNode.next;
            length++;
        }
        return length;
    }

    //Q3
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        ListNode next = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null || curr2 != null) {
            if (curr1 != null && curr2 != null) {
                if (curr1.val > curr2.val) {
                    next = curr2;
                    curr2 = curr2.next;
                } else {
                    next = curr1;
                    curr1 = curr1.next;
                }
            }else if (curr1 != null) {
                next = curr1;
                curr1 = curr1.next;
            }else if (curr2 != null) {
                next = curr2;
                curr2 = curr2.next;
            }
            if (head == null) {
                head = next;
                curr = head;
            } else {
                curr.next = next;
                curr = curr.next;
            }
        }
        return head;
    }

    //Q4
    //HashMap
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode[]> listMap = new HashMap<>();
        ListNode currNode = head;
        ListNode prevNode = null;
        int count = 0;
        while (currNode != null) {
            listMap.put(count, new ListNode[]{prevNode, currNode.next});
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
        int deleteIndex = count - n;
        if (deleteIndex == 0) {
            return head.next;
        } else {
            prevNode = listMap.get(deleteIndex)[0];
            prevNode.next = listMap.get(deleteIndex)[1];
        }
        return head;
    }
    //Two pointers
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = dummy;
        dummy.next = head;
        while (n != 1) {
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;

        return dummy.next;
    }

    //Q5
    class Node {
        int data;
        Node next, child;
        Node(int d) {
            data = d;
            next = child = null;
        }
    }

    public Node flattenList(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Node dummyFlatten = new Node(0);
        Node prevFlatten = dummyFlatten;
        Node curr;
        queue.offer(node);
        while (!queue.isEmpty()) {
            curr = queue.poll();

            while (curr != null) {
                if (curr.child != null) {
                    queue.offer(curr.child);
                }
                prevFlatten.next = curr;
                prevFlatten = prevFlatten.next;
                curr = curr.next;
            }
        }
        return dummyFlatten.next;
    }

    //Tree
    //Q1
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root, TreeNode rootParentLeft, TreeNode rootParentRight) {
        if (root == null) return true;
        boolean left = isValidBSTHelper(root.left, rootParentLeft, root);
        boolean right = isValidBSTHelper(root.right, root, rootParentRight);

        if (left && right) {
            if (root.left != null) {
                if (rootParentLeft != null) {
                    if (root.left.val >= root.val || root.left.val <= rootParentLeft.val) return false;
                }
                if (root.left.val >= root.val) return false;
            }
            if (root.right != null) {
                if (rootParentRight != null) {
                    if (root.right.val <= root.val || root.right.val >= rootParentRight.val) return false;
                }
                if (root.right.val <= root.val) return false;
            }
            return true;
        }
        return false;
    }

    //Only pass values instead of nodes
    public boolean isValidBST1(TreeNode root) {
        return isValidBSTHelper1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTHelper1(TreeNode root, int leftBound, int rightBound) {
        if (root == null) return true;
        if (root.val <= leftBound || root.val >= rightBound) return false;

        boolean left = isValidBSTHelper1(root.left, leftBound, root.val);
        boolean right = isValidBSTHelper1(root.right, root.val, rightBound);
        return left && right;
    }

    //Q2
    class ResultType {
        int height;
        boolean isBalanced;
        ResultType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).isBalanced;
    }
    public ResultType isBalancedHelper(TreeNode root) {
        if (root == null) return new ResultType(0, true);
        ResultType left = isBalancedHelper(root.left);
        ResultType right = isBalancedHelper(root.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <=1;
        int height = Math.max(left.height, right.height) + 1;
        return new ResultType(height, isBalanced);
    }

    //Q3
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = Integer.MIN_VALUE;
        diameterOfBinaryTreeHelper(root);
        return diameter == Integer.MIN_VALUE ? 0 :  diameter;
    }
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    //Q4
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumNumbersHelper(root, 0);
        return sum;
    }

    public void sumNumbersHelper(TreeNode root, int pathSum) {
        if (root == null) return;
        pathSum = pathSum*10 + root.val;
        if (root.left == null && root.right == null) {
            sum += pathSum;
        }
        sumNumbersHelper(root.left, pathSum);
        sumNumbersHelper(root.right, pathSum);
    }

    //Q5
    //Find the smallest number larger than p
    TreeNode successor;
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    //Q6
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }

    //Q7
    //In order traversal
    TreeNode p;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == p) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        TreeNode prevNode = null;
        while (!stack.isEmpty() || currNode != null) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                currNode = stack.pop();
                if (prevNode == p) return currNode;
                prevNode = currNode;
                currNode = currNode.right;
            }
        }
        return null;
    }
}