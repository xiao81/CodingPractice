package InterviewBit;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Arrays {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int sum = 0;
        for (int i = 0; i < X.size() - 1; i++) {
            int x1 = X.get(i);
            int x2 = X.get(i+1);
            int y1 = Y.get(i);
            int y2 = Y.get(i+1);
            int deltaX = Math.abs(x1 - x2);
            int deltaY = Math.abs(y1 - y2);
            sum += deltaX > deltaY ? deltaX : deltaY;
        }
        return sum;
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] resultRange = new int[2];
        int start = 0;
        int end = 0;
        int maxSum = 0;
        int currSum = 0;
        for (int num : a) {
            if (num >= 0) {
                end++;
                currSum += num;
            } else {
                if (currSum > maxSum) {
                    resultRange[0] = start;
                    resultRange[1] = end;
                } else if (currSum == maxSum) {
                    if (end - start > resultRange[1] - resultRange[0]) {
                        resultRange[0] = start;
                        resultRange[1] = end;
                    }
                }
                end++;
                start = end;
            }

            if (currSum > maxSum) {
                resultRange[0] = start;
                resultRange[1] = end;
            } else if (currSum == maxSum) {
                if (end - start > resultRange[1] - resultRange[0]) {
                    resultRange[0] = start;
                    resultRange[1] = end;
                }
            }
            for (int i = start; i <= end; i++) {
                resultList.add(a.get(i));
            }
        }
        return resultList;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 1;
        int value = 0;
        for (int i = a.size() - 1; i >=0; i--) {
            value = a.get(i) + carry;
            carry = value/10;
            value = value%10;
            result.add(0, value);
        }
        if (carry > 0) result.add(0, carry);
        while (result.get(0) == 0) {
            result.remove(0);
        }

        return result;
    }

    public int maxSubArray(final List<Integer> a) {
        if (a == null || a.size() == 0) return 0;
        if (a.size() == 1) return a.get(0);
        int[] dp = new int[a.size()];
        dp[0] = a.get(0);
        int max = dp[0];
        for (int i = 1; i < a.size(); i++) {
            dp[i] = a.get(i - 1) > 0 ? dp[i - 1] + a.get(i) : a.get(i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int maxArr(ArrayList<Integer> A) {
        int max = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                max = Math.max(max, Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j));
            }
        }
        return max;
    }
}
