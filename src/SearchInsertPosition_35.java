/**
 * Created by xiaoxiao on 7/21/17.
 */
public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        SearchInsertPosition_35 searchInsertPosition_35 = new SearchInsertPosition_35();
        System.out.println(searchInsertPosition_35.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsertPosition_35.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsertPosition_35.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(searchInsertPosition_35.searchInsert(new int[]{1,3,5,6},0));
    }
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }
}
