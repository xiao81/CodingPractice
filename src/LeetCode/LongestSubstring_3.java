import java.util.HashSet;

/**
 * Created by xiaoxiao on 6/3/17.
 */
public class LongestSubstring_3 {
    public static void main(String[] args) {
        LongestSubstring_3 l = new LongestSubstring_3();
        l.lengthOfLongestSubstring("dvdf");
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, i = 0, sum = 0;
        HashSet<Character> set = new HashSet<>();
        while (i != s.length()) {
            if (set.contains(s.charAt(i))) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                set.clear();
            }
            sum++;
            set.add(s.charAt(i));
            i++;
        }
        return Math.max(max, sum);
    }
}
