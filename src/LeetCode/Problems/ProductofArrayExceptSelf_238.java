package LeetCode.Problems;

import java.util.Arrays;

/**
 * Created by xiaoxiao on 4/27/17.
 */
public class ProductofArrayExceptSelf_238 {
    public static void main(String[] args) {
        ProductofArrayExceptSelf_238 p = new ProductofArrayExceptSelf_238();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{9,0,-2})));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int leftPrev = nums[0];
        int rightPrev = nums[nums.length-1];
        result[0]=1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = leftPrev;
            leftPrev *= nums[i];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            result[i] *= rightPrev;
            rightPrev *= nums[i];
        }
        return result;

    }
}
