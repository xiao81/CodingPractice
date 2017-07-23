package LeetCode;

/**
 * Created by xiaoxiao on 5/23/17.
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[majorIndex] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorIndex = i;
                count = 1;
            }
        }
        return nums[majorIndex];
    }
}
