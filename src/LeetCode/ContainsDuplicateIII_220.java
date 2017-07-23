/**
 * Created by xiaoxiao on 7/1/17.
 */
public class ContainsDuplicateIII_220 {
    public static void main(String[] args) {
        System.out.println(ContainsDuplicateIII_220.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647},1,2147483647));
    }
    static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) <= k && Math.abs((double)nums[i]/2 - (double)nums[j]/2) <= (double)t/2) {
                    return true;
                }
            }
        }
        return false;
    }
}
