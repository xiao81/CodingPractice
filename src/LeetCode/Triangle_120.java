package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size()-1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        int minTotal = Integer.MAX_VALUE;
        for(int i = 0; i < dp[triangle.size()-1].length; i++) {
            if (dp[triangle.size()-1][i] < minTotal) minTotal = dp[triangle.size()-1][i];
        }
        return minTotal;
    }

}
