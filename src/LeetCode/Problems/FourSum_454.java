package LeetCode.Problems;

import java.util.HashMap;

/**
 * Created by xiaoxiao on 5/23/17.
 */
public class FourSum_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int size = A.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = map.getOrDefault(-(C[i]+D[j]),0);
                if (sum != 0) {
                    result+=sum;
                }
            }
        }
        return result;
    }
}
