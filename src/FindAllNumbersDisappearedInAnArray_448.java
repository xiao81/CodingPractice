import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoxiao on 7/21/17.
 */
public class FindAllNumbersDisappearedInAnArray_448 {
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray_448 findAllNumbersDisappearedInAnArray_448 = new FindAllNumbersDisappearedInAnArray_448();
        System.out.println(findAllNumbersDisappearedInAnArray_448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findAllNumbersDisappearedInAnArray_448.findDisappearedNumbers(new int[]{4,3,2,7,7,2,3,1}));
        System.out.println(findAllNumbersDisappearedInAnArray_448.findDisappearedNumbers(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,32}));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> returnList = new ArrayList<>();
        if (nums.length == 0) {
            return returnList;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] >0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                returnList.add(i+1);
            }
        }
        return returnList;
    }

}
