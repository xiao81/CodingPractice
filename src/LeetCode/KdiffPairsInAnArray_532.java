import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class KdiffPairsInAnArray_532 {
    //Brute force
    HashSet<String> pairSet = new HashSet<>();
    public int findPairs(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    String pair;
                    if (nums[i] > nums[j]) {
                        pair = Integer.toString(nums[i]) + Integer.toString(nums[j]);
                    } else {
                        pair = Integer.toString(nums[j]) + Integer.toString(nums[i]);
                    }
                    pairSet.add(pair);
                }
            }
        }
        return pairSet.size();
    }

    //HashMap count the occurrence

    public int findPairs2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (k == 0) {
                if (entry.getValue() > 1) count++;
            } else {
                if (map.containsKey(entry.getKey() + k)) count++;
            }
        }
        return count;
    }
}
