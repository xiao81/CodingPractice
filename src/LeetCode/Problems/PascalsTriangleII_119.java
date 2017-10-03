package LeetCode.Problems;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
    public static void main(String[] args) {
        PascalsTriangleII_119 pascalsTriangleII_119 = new PascalsTriangleII_119();
        System.out.println(pascalsTriangleII_119.getRow(3).toString());
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j >= 1; j--) {
                 row.set(j, row.get(j-1) + row.get(j));
            }
        }
        return row;
    }
}
