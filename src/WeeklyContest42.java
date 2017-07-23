import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class WeeklyContest42 {
    public static void main(String[] args) {
        WeeklyContest42 weeklyContest42 = new WeeklyContest42();

    }
    public int[] findErrorNums(int[] nums) {
        int[] countArray = new int[nums.length];
        int[] result = new int[2];
        for (int num : nums) {
            countArray[num-1]++;
        }
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 2) {
                result[0] = i + 1;
            }
            if (countArray[i] == 0) {
                result[1] = i + 1;
            }

        }
        return result;
    }

    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        HashSet<String> dictSet = new HashSet<>();
        StringBuffer result = new StringBuffer();
        for (String word : dict) {
            dictSet.add(word);
        }
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            int i;
            for (i = 0; i < word.length(); i++) {
                sb.append(word.charAt(i));
                if (dictSet.contains(sb.toString())) {
                    result.append(sb.toString());
                    result.append(" ");
                    break;
                }
            }
            if (i == word.length()) {
                result.append(word);
                result.append(" ");
            }
        }
        return result.toString().substring(0,result.length()-1);
    }
    int count = 0;
    String str;
    public int countSubstrings(String s) {
        str = s;
        for (int i = 0; i < s.length(); i++) {
            expand(i,i);
            expand(i,i+1);
        }
        return count;
    }

    private void expand(int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public int findLongestChain(int[][] pairs) {
        ArrayList<Pair> pairList = new ArrayList<>();
        Arrays.sort(pairs,Comparator.comparing((int[] arr) -> arr[1]));
        int count = 1;
        int j = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > pairs[j][1]) {
                count++;
                j = i;
            }
        }
        return count;
    }

}
