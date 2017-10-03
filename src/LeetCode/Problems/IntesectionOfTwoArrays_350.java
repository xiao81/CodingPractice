package LeetCode.Problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoxiao on 5/23/17.
 */
public class IntesectionOfTwoArrays_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums1.length;i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length;i++) {
            if (map.getOrDefault(nums2[i],0) != 0) {
                map.put(nums2[i],map.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size();i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
