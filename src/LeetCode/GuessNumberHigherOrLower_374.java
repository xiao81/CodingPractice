package LeetCode;

public class GuessNumberHigherOrLower_374 {
    private  int guess(int input) {
        return 0;
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int response = guess(mid);
            if (response == 0) {
                return mid;
            } else if (response == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return n;
    }
}
