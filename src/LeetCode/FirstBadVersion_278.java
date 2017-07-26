package LeetCode;

public class FirstBadVersion_278 {
    //Dummy method
    private boolean isBadVersion(int version) {
        return true;
    }
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low + 1 < high) {
            int mid = (low + high) >>> 1;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return isBadVersion(low) ? low : high;
    }
}
