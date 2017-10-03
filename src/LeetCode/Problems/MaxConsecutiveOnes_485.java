package LeetCode.Problems;

public class MaxConsecutiveOnes_485 {
    public static void main(String[] args) {
        MaxConsecutiveOnes_485 maxConsecutiveOnes_485 = new MaxConsecutiveOnes_485();
        System.out.println(maxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
    //Brute force
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count,max);
    }
}
