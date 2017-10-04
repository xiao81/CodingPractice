package Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Assignment9 {
    public static void main(String[] args) {
        Assignment9 assignment9 = new Assignment9();
        System.out.println("Q1");
        System.out.println(assignment9.isReachable(new int[]{1,2,3,4}, 21)); // (1+2)*(3+4)
        System.out.println(assignment9.isReachable(new int[]{1,2,3,4}, 24)); //(1+2+3)*4
        System.out.println(assignment9.isReachable(new int[]{1,2,3,4}, 100));
        System.out.println(assignment9.isReachable(new int[]{}, 100));
        System.out.println("Q3");
        System.out.println(assignment9.longestBitonicSubarray(new int[]{12, 4, 78, 90, 45, 23}));
        System.out.println(assignment9.longestBitonicSubarray(new int[]{20, 4, 1, 2, 3, 4, 2, 10}));
        System.out.println(assignment9.longestBitonicSubarray(new int[]{10}));
        System.out.println(assignment9.longestBitonicSubarray(new int[]{10, 20, 30, 40}));
        System.out.println(assignment9.longestBitonicSubarray(new int[]{40, 30, 20, 10}));
        System.out.println(assignment9.longestBitonicSubarray(new int[]{}));
        System.out.println("Q4");
        System.out.println(assignment9.maxSum(new int[]{4,2,1,8}));
        System.out.println(assignment9.maxSum(new int[]{10,12,15}));
        System.out.println(assignment9.maxSum(new int[]{1,2}));
        System.out.println(assignment9.maxSum(new int[]{1}));
        System.out.println("Q5");
        System.out.println(Arrays.toString(assignment9.reOrderArray(new int[]{1, 3, 0, 2})));
        System.out.println(Arrays.toString(assignment9.reOrderArray(new int[]{2, 0, 1, 4, 5, 3})));
        System.out.println(Arrays.toString(assignment9.reOrderArray(new int[]{0, 1, 2, 3})));
        System.out.println(Arrays.toString(assignment9.reOrderArray(new int[]{3, 2, 1, 0})));
        System.out.println("Q6");
        System.out.println(assignment9.findMaxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
        System.out.println(assignment9.findMaxDiff(new int[]{7, 9, 5, 6, 3, 2}));
        System.out.println(assignment9.findMaxDiff(new int[]{3,2,1}));
        System.out.println(assignment9.findMaxDiff(new int[]{1}));
        System.out.println("Q7");
        System.out.println(Arrays.toString(assignment9.nextGreaterElements(new int[] {4,5,2,25})));
        System.out.println(Arrays.toString(assignment9.nextGreaterElements(new int[] {13,7,6,12})));
        System.out.println(Arrays.toString(assignment9.nextGreaterElements(new int[] {3,8,4,1,2})));
        System.out.println("Q8");
        System.out.println(assignment9.maximumSumPath(new int[]{2, 3, 7, 10, 12}, new int[]{1, 5, 7, 8}));
        System.out.println(assignment9.maximumSumPath(new int[]{2, 3, 7, 10, 12, 15, 30, 34}, new int[]{1, 5, 7, 8, 10, 15, 16, 19}));
        System.out.println("Q9");
        System.out.println(assignment9.findMaxNum(new int[] {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}));
        System.out.println(assignment9.findMaxNum(new int[] {1, 3, 50, 10, 9, 7, 6}));
        System.out.println(assignment9.findMaxNum(new int[] {10, 20, 30, 40, 50}));
        System.out.println(assignment9.findMaxNum(new int[] {120, 100, 80, 20, 0}));
        System.out.println(assignment9.findMaxNum(new int[] {120, 100}));
        System.out.println(assignment9.findMaxNum(new int[] {}));


    }
    //Q1
    public boolean isReachable(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int result : isReachableHelper(nums, 0, nums.length - 1)) {
                if (result == target) return true;
            }
        }
        return false;
    }
    private List<Integer> isReachableHelper(int[] nums, int start, int end) {
        List<Integer> resultList = new ArrayList<>();
        if (start > end) return resultList;
        else if (start == end) {
            resultList.add(nums[start]);
            return resultList;
        } else {
            for (int i = start; i < end; i++) {
                List<Integer> leftResult = isReachableHelper(nums, start, i);
                List<Integer> rightResult =isReachableHelper(nums, i + 1, end);
                for (int x : leftResult) {
                    for (int y : rightResult) {
                        resultList.add(x + y);
                        resultList.add(x - y);
                        resultList.add(x * y);
                        if (y != 0) resultList.add(x / y);
                    }
                }
            }
        }
        return resultList;
    }

    //Q2
    public int uniquePaths(int m, int n) {
        int[][] dp  = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    //Q3
    public int longestBitonicSubarray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int maxLength = 0;
        int[] lia = new int[nums.length];
        int[] lda = new int[nums.length];
        lia[0] = 1;
        lda[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) lia[i] = lia[i - 1] + 1;
            else lia[i] = 1;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) lda[i] = lda[i + 1] + 1;
            else lda[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, lia[i] + lda[i] - 1);
        }
        return maxLength;
    }
    //Q4
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum -= nums[i] * 2;
            sum += nums[nums.length - 1 - i] * 2;
        }
        return sum;
    }

    //Q5
    public int[] reOrderArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i]++;
        }
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                reOrderArrayHelper(nums, i);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i] - 1;
        }
        return nums;
    }
    public void reOrderArrayHelper(int[] nums, int i) {
        int val = -(i + 1);
        i = nums[i] - 1;
        while ( nums[i] > 0) {
            int temp = nums[i] - 1;
            nums[i] = val;
            val = -(i + 1);
            i = temp;
        }
    }

    //Q6
    int findMaxDiff(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxDiff = Math.max(maxDiff, num - minValue);
        }
        return maxDiff;
    }

    //Q7
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > nums[i]) {
                    result[i] = stack.peek();
                    stack.push(nums[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(nums[i]);
            }
        }
        return result;
    }

    //Q8
    public int maximumSumPath(int[] nums1, int[] nums2) {
        int result = 0, nums1Sum = 0, nums2Sum = 0;
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] > nums2[j]) {
                    nums2Sum += nums2[j++];
                }
                else if (nums1[i] < nums2[j]) {
                    nums1Sum += nums1[i++];
                } else {
                    result += Math.max(nums1Sum, nums2Sum) + nums1[i];
                    nums1Sum = 0;
                    nums2Sum = 0;
                    i++;
                    j++;
                }
            } else if (i < nums1.length) {
                nums1Sum += nums1[i++];
            } else {
                nums2Sum += nums2[j++];
            }
        }
        return Math.max(nums1Sum, nums2Sum) + result;
    }

    //Q9
    public int findMaxNum(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (start == end) return nums[start];
            else if (start + 1 == end) {
                return Math.max(nums[start], nums[end]);
            }
            int mid = start + (end - start) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }




}
