package LeetCode.Problems;

import java.util.HashMap;

/**
 * Created by xiaoxiao on 5/23/17.
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            int value = map.getOrDefault(i,0);
            if (value > 0) {
                return true;
            }
            map.put(i, 1);
        }
        return false;
    }
}
