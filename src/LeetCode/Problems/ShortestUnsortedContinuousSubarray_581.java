package LeetCode.Problems;

public class ShortestUnsortedContinuousSubarray_581 {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray_581 shortestUnsortedContinuousSubarray_581 = new ShortestUnsortedContinuousSubarray_581();
        System.out.println(shortestUnsortedContinuousSubarray_581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
