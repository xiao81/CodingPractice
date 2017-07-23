/**
 * Created by xiaoxiao on 4/26/17.
 */
public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        String binString = Integer.toBinaryString(x ^ y);
        int distance = 0;
        for (int i = 0; i < binString.length(); i++) {
            if (binString.charAt(i) == '1') {
                distance++;
            }
        }
        return distance;
    }
}
