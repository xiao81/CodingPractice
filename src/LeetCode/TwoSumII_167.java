import java.util.Arrays;

/**
 * Created by xiaoxiao on 7/21/17.
 */
public class TwoSumII_167 {
    public static void main(String[] args) {
        TwoSumII_167 twoSumII_167 = new TwoSumII_167();
        System.out.println(Arrays.toString(twoSumII_167.twoSum(new int[]{2, 7, 11, 15},9)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left != right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
