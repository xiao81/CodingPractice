package LeetCode.Problems;
public class ThirdMaximumNumber_414 {
    public static void main(String[] args) {
        ThirdMaximumNumber_414 thirdMaximumNumber_414 = new ThirdMaximumNumber_414();
        System.out.println(thirdMaximumNumber_414.thirdMax(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));
    }
    private Integer max = null;
    private Integer max2 = null;
    private Integer max3 = null;
    public int thirdMax(int[] nums) {
        for (Integer num : nums) {
            if (num.equals(max) || num.equals(max2) || num.equals(max3)) continue;
            if (max == null || num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            } else if (max2 == null || num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null ||num >= max3) {
                max3 = num;
            }
        }
        return max3 == null ? max : max3;
    }
}
