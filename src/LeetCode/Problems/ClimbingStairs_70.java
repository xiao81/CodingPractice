package LeetCode.Problems;

/**
 * Created by xiaoxiao on 5/29/17.
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev =2, prevBefore =1, sum = 0;
        for (int i = 3; i <=n;i++) {
            sum = prev + prevBefore;
            prevBefore = prev;
            prev = sum;
        }
        return sum;
    }
}
