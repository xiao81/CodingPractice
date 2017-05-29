import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoxiao on 5/28/17.
 */
public class Permutations_46 {
    private List<List<Integer>> resultList = new LinkedList<>();
    private int[] inputArr;
    public List<List<Integer>> permute(int[] nums) {
        inputArr = nums;
        permuteHelper(new LinkedList<Integer>());
        return resultList;
    }
    public void permuteHelper(List<Integer> list) {
        if (list.size() == inputArr.length) {
            resultList.add(new LinkedList<Integer>(list));
            return;
        }

        for (int i = 0; i < inputArr.length;i++) {
            if (list.contains(inputArr[i])) continue;
            list.add(inputArr[i]);
            permuteHelper(list);
            list.remove(list.size()-1);
        }

    }
}
