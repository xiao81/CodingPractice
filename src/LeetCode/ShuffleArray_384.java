/**
 * Created by xiaoxiao on 5/23/17.
 */
public class ShuffleArray_384 {
    private int[] inputArr;
    public ShuffleArray_384(int[] nums) {
         this.inputArr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.inputArr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[this.inputArr.length];
        for (int i = 0; i < result.length; i++) {
            int randIndex = (int) (Math.random() * (i+1));
            result[i] = result[randIndex];
            result[randIndex] = this.inputArr[i];
        }
        return result;

    }
}
