package LeetCode.Problems;

/**
 * Created by xiaoxiao on 5/29/17.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i =1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i-1] > 0 ? dp[i-1] : 0;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
