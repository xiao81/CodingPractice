package LeetCode.WeeklyContest;

import java.util.ArrayList;
import java.util.Arrays;

public class WeeklyContest53 {
    public boolean hasAlternatingBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        for (int i = 1; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == binaryString.charAt(i - 1)) return false;
        }
        return true;
    }
    int[][] dirArray = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    int[][] grid;
    int maxArea;
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        maxArea = 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(i, j), maxArea);
                }
            }
        }
        return maxArea;
    }
    int dfs(int i, int j) {
        grid[i][j] = 2;
        int area = 1;
        for (int[] dir : dirArray) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                area += dfs(x, y);
            }
        }
        return area;
    }

}
