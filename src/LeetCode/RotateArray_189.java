package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray_189 {
    public static void main(String[] args) {
        RotateArray_189 rotateArray_189 = new RotateArray_189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotateArray_189.rotate(nums, 3);

    }
    private int[] numArr;
    public void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0 || k == nums.length) return;
        numArr = nums;
        k %= nums.length;
        reverse(0, nums.length - 1);
        reverse(0, k - 1);
        reverse(k, nums.length - 1);

    }
    private void reverse(int left, int right) {
        for (int i = 0; i <= (right - left) / 2; i++) {
            swap(i+left, right - i);
        }
    }
    private void swap(int i, int j) {
        int temp;
        temp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = temp;
    }
}
