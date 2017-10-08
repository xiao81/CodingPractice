package Assignments;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class Assignment10 {
    public static void main(String[] args) {
        Assignment10 assignment10 = new Assignment10();
        System.out.println(assignment10.longestNonPalindrome("aaaa"));
        System.out.println(assignment10.longestNonPalindrome("abba"));
        System.out.println(assignment10.longestNonPalindrome("abcd"));
        System.out.println(assignment10.longestNonPalindrome("ab"));
        System.out.println("Q6");
        CustomizedStack customziedStack = new CustomizedStack();
        customziedStack.push(1);
        customziedStack.push(2);
        customziedStack.push(3);
        customziedStack.push(4);
        customziedStack.push(5);
        System.out.println(customziedStack.findMiddle());
        System.out.println(customziedStack.pop());
        System.out.println(customziedStack.findMiddle());
        System.out.println(customziedStack.pop());
        System.out.println(customziedStack.findMiddle());
        System.out.println(customziedStack.pop());
        System.out.println(customziedStack.findMiddle());
        System.out.println(customziedStack.pop());
        System.out.println(customziedStack.findMiddle());
        System.out.println(customziedStack.pop());
        System.out.println(customziedStack.findMiddle());
        System.out.println("Q10");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        assignment10.reverse(stack);
        System.out.println("Q9");
        System.out.println(stack);
        stack.push(-1);
        stack.push(-2);
        stack.push(-3);
        stack.push(-4);
        stack.push(-5);
        assignment10.sort(stack);
        System.out.println(stack);
        System.out.println("Q8");
        int graph[][] = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
        System.out.println(assignment10.findCelebrity(graph));
        System.out.println("Q5");
        int[][] arr =
                {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println(assignment10.rotOranges(arr));
        int[][] arr1 = { {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        System.out.println(assignment10.rotOranges(arr1));

    }
    //Q1
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(i);
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[wordDict.size()];
    }

    //Q2
    List<List<String>> result;
    List<String> currList;
    public List<List<String>> partition(String s) {

        result = new ArrayList<>();
        currList = new ArrayList<>();
        partitionHelper(s, 0);
        return result;
    }
    void partitionHelper(String s, int left) {
        if (!currList.isEmpty() && left >= s.length()) {
            result.add(new ArrayList<>(currList));
        }
        for (int i = left; i < s.length(); i++) {
            if (isPalindrome(s, left, i)) {
                if (left == i)
                    currList.add(Character.toString(s.charAt(i)));
                else
                    currList.add(s.substring(left, i + 1));
                partitionHelper(s, i + 1);
                currList.remove(currList.size() - 1);
            }
        }

    }
    boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //Q3
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    //Q4
    String string;
    public int longestNonPalindrome(String s) {
        int i, left = 0, right = s.length() - 1;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(0) != s.charAt(i)) break;
        }
        if (i == s.length()) return 0;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) break;
            else {
                left++;
                right--;
            }
        }
        return (left <= right) ? s.length() : s.length() - 1;
    }

    //Q5
    final int[][] dirArray = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    int m, n;
    int rotOranges(int matrix[][]) {
        Queue<Orange> queue = new LinkedList<>();
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) queue.offer(new Orange(i, j));
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Orange currOrange = queue.poll();
                for (int[] dir : dirArray) {
                    int x = currOrange.x + dir[0];
                    int y = currOrange.y + dir[1];
                    if (x >= 0 && x < m && y >=0 && y < n && matrix[x][y] == 1) {
                        matrix[x][y] = 2;
                        queue.offer(new Orange(x, y));
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) return -1;
            }
        }
        return count - 1;
    }
    class Orange {
        int x;
        int y;
        Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    //Q6
    static class CustomizedStack {
        Node head;
        Node tail;
        Node mid;
        int size;

        CustomizedStack() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
            mid = tail;
            size = 0;
        }

        void push(int val) {
            Node newNode = new Node(val);
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            size++;
            if (size % 2 != 0) mid = mid.prev;
        }

        int pop() {
            if (size == 0) throw new EmptyStackException();
            int returnValue = head.next.val;
            if (size % 2 != 0) mid = mid.next;
            head.next = head.next.next;
            head.next.prev = head;
            size--;
            return returnValue;
        }

        int findMiddle() {
            return mid.val;
        }

        void deleteMiddle() {
            if (size == 0) return;
            mid.prev.next = mid.next;
            mid.next.prev = mid.prev;
        }

    }
    static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    //Q7
    static class MinStack {
        Stack<Integer> stack;
        int minValue;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minValue = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x < minValue) {
                stack.push(minValue);
                minValue = x;
            }

            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == minValue) {
                minValue = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minValue;
        }
    }

    //Q8
    int findCelebrity(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++){
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (graph[a][b] == 1) stack.push(b);
            else stack.push(a);
        }
        int result = stack.pop();
        for (int i = 0; i < graph.length; i++) {
            if (i != result && (graph[result][i] == 1 || graph[i][result] != 1)) {
                return -1;
            }
        }
        return result;
    }

    //Q9
    void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        sort(stack);
        insert(stack, val);
    }
    void sortInsert(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
        } else {
            int top = stack.pop();
            insert(stack,val);
            stack.push(val);
        }
    }

    //Q10
    void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        reverse(stack);
        insert(stack, val);
    }
    void insert(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
        }
        else {
            int top = stack.pop();
            insert(stack,val);
            stack.push(top);
        }
    }

















































}
