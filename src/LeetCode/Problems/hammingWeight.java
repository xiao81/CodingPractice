package LeetCode.Problems;

/**
 * Created by xiaoxiao on 3/1/17.
 */
public class hammingWeight {
    public static void main(String[] args) {

    }
    public int hammingWeight(int n) {
        int count = 0;
        String bitString = Integer.toBinaryString(n);
        for (int i = 0; i < bitString.length(); i++) {
            if (bitString.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}
