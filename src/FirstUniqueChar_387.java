/**
 * Created by xiaoxiao on 5/23/17.
 */
public class FirstUniqueChar_387 {
    public int firstUniqChar(String s) {
        int[] charArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charArr[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }
}
