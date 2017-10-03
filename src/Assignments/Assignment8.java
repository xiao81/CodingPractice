package Assignments;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class Assignment8 {
    public static void main(String[] args) {
        Assignment8 assignment8 = new Assignment8();
        System.out.println("Q10");
        System.out.println(assignment8.longestBitonicSubsequence(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
        System.out.println(assignment8.longestBitonicSubsequence(new int[]{12, 11, 40, 5, 3, 1}));
        System.out.println(assignment8.longestBitonicSubsequence(new int[]{80, 60, 30, 40, 20, 10}));
        System.out.println(assignment8.longestBitonicSubsequence(new int[]{}));
        System.out.println(assignment8.longestBitonicSubsequence(new int[]{5}));
        System.out.println("Q11");
        System.out.println(assignment8.findSubArray(new int[]{1, 0, 1, 1, 1, 0, 0}));
        System.out.println(assignment8.findSubArray(new int[]{1, 1, 1, 1}));
        System.out.println(assignment8.findSubArray(new int[]{0, 0, 1, 1, 0}));
        System.out.println(assignment8.findSubArray(new int[]{1}));
        System.out.println("Q12");
        System.out.println(assignment8.maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
        System.out.println(assignment8.maxIndexDiff(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0}));
        System.out.println(assignment8.maxIndexDiff(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(assignment8.maxIndexDiff(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(assignment8.maxIndexDiff(new int[]{}));
        System.out.println(assignment8.maxIndexDiff(new int[]{6}));
        System.out.println("Q13");
        System.out.println(assignment8.maxProfit(new int[]{10, 22, 5, 75, 65, 80}));
        System.out.println(assignment8.maxProfit(new int[]{2, 30, 15, 10, 8, 25, 80}));
        System.out.println(assignment8.maxProfit(new int[]{100, 30, 15, 10, 8, 25, 80}));
        System.out.println(assignment8.maxProfit(new int[]{90, 80, 70, 60, 50}));
        System.out.println(assignment8.maxProfit(new int[]{}));
        System.out.println(assignment8.maxProfit(new int[]{90}));
        System.out.println(assignment8.maxProfit(new int[]{80, 90}));





    }
    //Q1
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    //Q2
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] >= 3) return true;
                }
            }
            if (dp[i] == 0) dp[i] = 1;
        }
        return false;
    }

    //Q3
    class NumMatrix {
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix[0].length == 0) return;
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }
    }

    //Q4
    //private static final int[][] dirArray = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 maxLength = Math.max(maxLength, longestIncreasingPathHelper(matrix, cache, i, j));
            }
        }
        return maxLength;
    }
    public int longestIncreasingPathHelper(int[][] matrix,int[][] cache, int i, int j) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] dir : dirArray) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], longestIncreasingPathHelper(matrix, cache, x, y));
            }
        }
        return ++cache[i][j];
    }

    //Q5
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + grid[i][j];
                } else if (j == 0) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + grid[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
            }
        }
        return dp[grid.length][grid[0].length];
    }

    //Q6
    //private static final int[][] dirArray = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    //int m, n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0]== null || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board, String word, int i, int j, int k) {
        if (word.charAt(k) != board[i][j]) return false;
        if (k == word.length() - 1) return true;
        boolean result = false;
        board[i][j] ^= 256;
        for (int idx = 0; idx < 4; idx++) {
            int x = i + dirArray[idx][0], y = j + dirArray[idx][1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                result = existHelper(board, word, x, y, k + 1);
                if (result) break;
            }
        }
        board[i][j] ^= 256;
        return result;
    }

    //Q7
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
                    maxLength = Math.max(maxLength, dp[i + 1][j + 1]);
                }

            }
        }
        return maxLength * maxLength;
    }
    //Q8
    private static final int[][] dirArray = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    int m, n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            solveHelper(board, i, 0);
            solveHelper(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            solveHelper(board, 0, i);
            solveHelper(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) board[i][j] = 'O';
            }
        }
    }
    public void solveHelper(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = 1;
            for (int[] dir : dirArray) {
                int x = i + dir[0], y = j + dir[1];
                if (x > 0 && x < m - 1 && y >0 && y < n - 1) {
                    solveHelper(board, x, y);
                }
            }
        }

     }
    //Q9

    //Q10
    public int longestBitonicSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];
        lis[0] = 1;
        lds[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) lis[i] = Math.max(0, lis[j]) + 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) lds[i] = Math.max(0, lds[j]) + 1;
            }
        }
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
        }
        return maxLength;
    }

    //Q11
    public int findSubArray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) maxLength = Math.max(maxLength, i + 1);
            map.putIfAbsent(sum, i);
            maxLength = Math.max(maxLength, i - map.get(sum));
        }
        return maxLength;
    }

    //Q12
    int maxIndexDiff(int[] nums) {
        int[] lMin = new int[nums.length];
        int[] rMax = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                lMin[i] = nums[i];
                min = nums[i];
            } else {
                lMin[i] = min;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                rMax[i] = nums[i];
                max = nums[i];
            } else {
                rMax[i] = max;
            }
        }
        int left = 0, right = 0, maxLength =0;
        while (right != nums.length && left != nums.length) {
            if (rMax[right] > lMin[left]) {
                maxLength = Math.max(maxLength, right - left);
                right++;
            }
            else left++;
        }
        return maxLength == 0 ? -1 : maxLength;
    }

    //Q13
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int i = 1;
        int buyPrice = prices[0];
        int profits = 0;
        while (i < prices.length) {
            if (prices[i] > prices[i - 1])i++;
            else {
                profits += prices[i - 1] - buyPrice;
                buyPrice = prices[i++];
            }
        }
        return prices[i - 1] > buyPrice ? profits + prices[i - 1] - buyPrice : profits;
    }




















































}
