import java.util.Arrays;

/**
 * Created by xiaoxiao on 4/25/17.
 */
public class ArrayPartition_561 {
    public static void main(String[] args) {
    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

}
