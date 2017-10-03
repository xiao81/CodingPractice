package LeetCode.Problems;

import java.util.HashSet;

/**
 * Created by xiaoxiao on 5/24/17.
 */
public class HappyNumber_202 {
    public static void main(String[] args) {
        HappyNumber_202 h = new HappyNumber_202();
        h.isHappy(19);
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int num =n, sum =0;
        while(sum != 1) {
            sum=0;
            while (num !=0) {
                sum += Math.pow(num%10,2);
                num/=10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                num=sum;
            }
        }
        return true;
    }
}
