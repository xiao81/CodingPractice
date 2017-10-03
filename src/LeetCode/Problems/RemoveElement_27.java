package LeetCode.Problems;

/**
 * Created by xiaoxiao on 7/21/17.
 */
public class RemoveElement_27 {
    public static void main(String[] args) {
        RemoveElement_27 removeElement_27 = new RemoveElement_27();
        System.out.println(removeElement_27.removeElement(new int[]{3,2,2,3},3));
        System.out.println(removeElement_27.removeElement(new int[]{3},3));
    }
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int right = nums.length-1;
        while (nums[right] == val) {
            if (right > 0) {
                right--;
            } else {
                return 0;
            }

        }
        int left = right;
        while (left >= 0){
            if (nums[left] == val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
            left--;
        }
        return right + 1;
    }
}
