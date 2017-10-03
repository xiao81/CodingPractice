package LeetCode.Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class IntersectionOfTwoArrays_349 {
    //Two pointers
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i != nums1.length && j != nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set) {
            result[k++] = num;
        }
        return result;
    }
}
