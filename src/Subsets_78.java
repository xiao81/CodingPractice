import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoxiao on 5/29/17.
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> intSet = new ArrayList<>();
        String binaryArr;
        for(int i = 0; i < (int)(Math.pow(2,nums.length)); i++) {
            binaryArr = Integer.toBinaryString(i);
            for (int j = 0; j < nums.length; j++) {
                if(binaryArr.length()<=j) {
                    break;
                } else {
                    if (binaryArr.charAt(binaryArr.length()-j-1) == '1') {
                        intSet.add(nums[j]);
                    }
                }
            }
            result.add(new ArrayList<Integer>(intSet));

            intSet.clear();
        }
        return result;
    }
    private List<List<Integer>> list = new LinkedList<>();
    private int[] inputArr;
    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        inputArr = nums;
        backtrack(new LinkedList<Integer>(),0);
        return list;
    }

    private void backtrack(List<Integer> tempList, int start){
        list.add(new LinkedList<>(tempList));
        for(int i = start; i < inputArr.length; i++){
            tempList.add(inputArr[i]);
            backtrack(tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
