import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoxiao on 5/24/17.
 */
public class GenerateParentheses_22 {
    private int size=0;
    private List<String> resultList = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        this.size = n;
        backtrack(0,0,"");
        return resultList;
    }
    private void backtrack(int left, int right, String str) {
        if (str.length() == this.size*2) {
            resultList.add(str);
            return;
        }

        if (left < this.size) {
            backtrack(left+1,right,str+'(');
        }
        if (right < left) {
            backtrack(left,right+1,str+')');
        }
    }
}
