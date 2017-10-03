package LeetCode.Problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_26 removeDuplicatesFromSortedArray_26 = new RemoveDuplicatesFromSortedArray_26();
        int[] array = new int[]{1,1,2};
        removeDuplicatesFromSortedArray_26.removeDuplicates(array);
        System.out.println(Arrays.toString(array));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int slow = 0, fast = 1;
        while(fast != nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;

        }
        return slow+1;
    }
}
