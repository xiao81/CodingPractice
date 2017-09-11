package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class WeeklyContest49 {
    public static void main(String[] args) {
        WeeklyContest49 weeklyContest49 = new WeeklyContest49();
        System.out.println(weeklyContest49.findLengthOfLCIS(new int[]{1,3,4,5,7}));
        System.out.println(weeklyContest49.findNumberOfLIS(new int[]{1,3,5,4,7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    class MagicDictionary {
        private HashMap<Integer, ArrayList<String>> dictionary;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            dictionary = new HashMap<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String string : dict) {
                dictionary.putIfAbsent(string.length(), new ArrayList<>());
                dictionary.get(string.length()).add(string);
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            ArrayList<String> compareList = dictionary.get(word.length());
            if (compareList == null) return false;
            else {
                for (int i = 0; i < compareList.size(); i++) {
                    String compareWord = compareList.get(i);
                    int count = 0;
                    for (int j = 0; j < compareWord.length(); j++) {
                        if (compareWord.charAt(j) != word.charAt(j)) count++;
                    }
                    if (count == 1) return true;
                }
            }
            return false;
        }
    }
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <=1) return nums.length;
        int[][] LIS = new int[nums.length][2];
        LIS[0][0] = 1;
        LIS[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (LIS[j][0] > max) {
                        max = LIS[j][0];
                        count = LIS[j][1];
                    } else if (LIS[j][0] == max) {
                        count += LIS[j][1];
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                LIS[i][0] = 1;
                LIS[i][1] = 1;
            } else {
                LIS[i][0] = max + 1;
                LIS[i][1] = count;
            }

        }
        int result = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < LIS.length; i++) {
            if (LIS[i][0] > maxLength) {
                maxLength = LIS[i][0];
                result = LIS[i][1];
            } else if (LIS[i][0] == maxLength) {
                result += LIS[i][1];
            }
        }
        return result;
    }

}
