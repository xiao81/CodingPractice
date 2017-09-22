package Assignments;

public class Assignment6 {
    //Q1 Binary Search logN
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[end] < nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }

    //Q2
    public int searchInArray(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return  nums[0] == target ? 0 : -1;

        int mid = nums.length / 2;
        int left = binarySearch(nums, target, 0, mid, false);
        int right = binarySearch(nums,target, mid + 1, nums.length - 1, true);
        return left != -1 ? left : right;
    }

    public int binarySearch(int[] nums, int target, int start, int end, boolean isInc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (isInc) {
                if (target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target < nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    //Q3

    //Q4
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int first = 0, second = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (second < nums.length) {
            System.out.println("First: " + first + " Second: " +second + " Sum: " +sum);
            sum += nums[second++];
            while (sum >=s){
                minLength = Math.min(second - first, minLength);
                sum -= nums[first++];
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //Q5
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0]= nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    //Q6
    public int maxProduct(int[] nums) {
        int maxSum = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = Math.max(min*nums[i], nums[i]);
                min = Math.min(temp*nums[i], nums[i]);
            } else {
                max = Math.max(max*nums[i], nums[i]);
                min = Math.min(min*nums[i], nums[i]);
            }
            maxSum = Math.max(maxSum, max);
        }
        return maxSum;
    }

    //Q8
    //Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 1;
        int majorIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[majorIndex] == nums[i]) count++;
            else count--;
            if (count == 0) {
                majorIndex = i;
                count = 1;
            }
        }
        return nums[majorIndex];
    }

    //Q9
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int count = 0;
            int tank = 0;
            while (count != gas.length) {
                tank += gas[j] - cost[j];
                j = j + 1 == gas.length ? 0 : j + 1;
                if (tank < 0) break;
                count++;
            }
            if (count == gas.length) return i;
        }
        return -1;
    }
}
