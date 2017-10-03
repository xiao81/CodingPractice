package LeetCode.Problems;

/**
 * Created by xiaoxiao on 5/23/17.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int sum =0;
        for (int i =0; i < nums.length;i++) {
            sum += nums[i];
        }

        return (nums.length*(nums.length+1))/2 - sum;
    }
}
