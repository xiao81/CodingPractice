package LeetCode.Problems;

public class ValidPerfectSquare_367 {
    //Recursive: Stack Overflow
    public boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        return isPerfectSquareHelper(1, num, num);
    }

    private boolean isPerfectSquareHelper(int start, int end, int num) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start)/2;
        if (mid * mid == num) {
            return true;
        } else if (mid * mid < num) {
            return isPerfectSquareHelper(mid + 1, end, num);
        } else {
            return isPerfectSquareHelper(start, mid -1, num);
        }
    }
    //Iteration
    public boolean isPerfectSquare1(int num) {
        if (num == 0) return false;
        long start = 1;
        long end = num;
        while (start <= end) {
            long mid = (start + end) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }
}
