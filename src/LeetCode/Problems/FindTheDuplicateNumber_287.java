package LeetCode.Problems;

/**
 * Created by xiaoxiao on 5/28/17.
 */
public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        int slow = 0,fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
