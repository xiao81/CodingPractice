package LeetCode;

public class ArrangeCoins_441 {
    public int arrangeCoins(int n) {
        int count = 0;
        int inc = 1;
        while (n > 0) {
            n -= inc;
            inc++;
            count++;
        }
        return n < 0 ? count - 1 : count;
    }
}
