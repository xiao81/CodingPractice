import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_118 {
    public static void main(String[] args) {
        PascalsTriangle_118 pascalsTriangle_118 = new PascalsTriangle_118();
        System.out.println(pascalsTriangle_118.generate(0).toString());
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                } else {
                    row.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }
}
