package LeetCode;

public class Sqrt_69 {

    //Binary Search: mid^2 <= x < (mid + 1)^2
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid > x){
                high = mid - 1;
            } else {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //Newton's method x = (x - num/2)/2
    public int mySqrt1(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x/r) >> 1;
        }
        return (int)r;
    }
}
