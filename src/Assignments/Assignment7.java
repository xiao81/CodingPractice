package Assignments;

import java.util.*;

public class Assignment7 {

    //Q1
    char[][] grid;
    int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
    List<List<Integer>> search2D(char grid[][],String word) {
        this.grid = grid;
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; i++) {
                if (search2DHelper(i, j, word)) {
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }
    boolean search2DHelper(int row, int col, String word) {
        if (grid[row][col] != word.charAt(0)) return false;
        for (int i = 0; i < 8; i++) {
            int j = 0, nextRow = row + x[i], nextCol = col + y[i];
            for (j = 1; j < word.length(); j++) {
                if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) break;
                if (grid[nextRow][nextCol] != word.charAt(j)) break;
                nextRow = row + x[i];
                nextCol = col + y[i];
            }
            if (j == word.length()) return true;
        }
        return false;
    }
    //Q2
    List<Integer> findZeroes(int m, int[] nums) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        int maxLeft = 0, maxRight = 0;
        List<Integer> result = new LinkedList<>();
        while (right < nums.length) {
            if (count <= m) {
                if (nums[right++] == 0) count++;

            } else {
                while (count > m) {
                    if (nums[left++] == 0) count--;
                }
            }
            if (right - left > maxRight - maxLeft) {
                maxLeft = left;
                maxRight = right;
            }
        }
        for (int i = maxLeft; i <= maxRight; i++) {
            if (nums[i] == 0) result.add(i);
        }
        return result;
    }
    //Q3
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    //Q4
    //Use Deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1){
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }

    //Q5
    class MovingAverage {
        Queue<Integer> queue;
        int sum;
        int size;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            sum = 0;
            this.size = size;
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.size() > size) {
                sum -= queue.poll();
            }
            return (double) sum / queue.size();
        }
    }

    //Q6
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) /2;
            if (target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        end = start;
        while (end < nums.length && nums[end] == target) end++;

        if (end >= 1 && start < nums.length && (nums[start] == target || nums[end] == target)) {
            return new int[]{start, end - 1};
        } else{
            return new int[]{-1,-1};
        }
    }

    //Q7
    public int twoUniques(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0, right = 0;
        while (right < string.length()) {
            if (map.size() < 2) {
                if (map.isEmpty()) map.put(string.charAt(right), right);
                else if (!map.containsKey(string.charAt(right))) map.put(string.charAt(right), right);
                right++;
            }
            else {
                if (map.containsKey(string.charAt(right))) right++;
                else {
                    int min = string.length();
                    char c = 0;
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        min = Math.min(min, entry.getValue());
                        c = entry.getKey();
                    }
                    map.remove(c);
                    map.put(string.charAt(right), right);
                    maxLength = Math.max(maxLength, right - min + 1);
                }
            }
        }
        return maxLength;
    }
    //Q8
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] result = new int[triangle.size()];
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j])+ triangle.get(i).get(j);
                }
            }
        }
        int minNum = Integer.MAX_VALUE;
        for (int k = 0; k < dp[dp.length - 1].length; k++) minNum = Math.min(minNum, dp[dp.length - 1][k]);
        return minNum;
    }
    //Q9
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()]* (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    //Q10
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax =0, rightMax = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[right]);
                }
                right--;
            }
        }
        return result;
    }


}
