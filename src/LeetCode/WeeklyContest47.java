package LeetCode;

import java.util.Arrays;

public class WeeklyContest47 {
    WeeklyContest47 weeklyContest47 = new WeeklyContest47();

    public static void main(String[] args) {

    }
    public boolean checkPossibility(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (index != -1) return false;
                else index = i;
            }
        }
        if (nums.length == 1 || index == -1) return true;

        if (index - 1 >= 0 && index + 2 < nums.length) {
            if (nums[index - 1] <= nums[index + 1] || nums[index] <= nums[index + 2]) return true;
        } else if (index - 1 >= 0) {
            if (nums[index] < 10000 || nums[index - 1] <= nums[index + 1]) return true;
        } else if (index + 2 < nums.length) {
            if (nums[index + 1] >= 1) return true;
        } else {
            return true;
        }

        return false;
    }

    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0]%10;
        int count = 0;
        int root = 0;
        int[] two = new int[2];
        int[] three = new int[4];
        int[] four = new int[8];
        Arrays.fill(two, -1);
        Arrays.fill(three, -1);
        Arrays.fill(four, -1);
        for (int i = nums.length - 1; i >= 0; i--) {
            int currNum = nums[i];
            if (currNum / 400 > 0) {
                four[currNum%100/10-1] = currNum%10;
            } else if (currNum / 300 > 0) {
                three[currNum%100/10-1] = currNum%10;
            } else if (currNum / 200 > 0) {
                two[currNum%100/10-1] = currNum%10;
            } else {
                root = currNum%10;
            }
        }
        for (int i = 0; i < four.length; i++) {
            if (four[i] != -1) count += four[i] + root;
        }
        for (int i = 0; i < three.length; i++) {
            if (three[i] != -1) {
                if (four[i*2] != -1 && four[i*2+1] != -1) count += three[i]*2;
                else if (four[i*2] != -1 || four[i*2+1] != -1) count += three[i];
                else count += three[i] + root;
            }
        }

        for (int i = 0; i < two.length; i++) {
            if (two[i] != -1) {
                boolean flag = false;
                for (int j = i*4; j < i*4 + 4; j++) {
                    if (four[j] != -1) {
                        count+= two[i] + root;
                        flag = true;
                    }
                }
                if (!flag) count+= two[i] + root;
            }
        }
        return count;

    }

}
