package BrightEdgeOnsite;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        Character prev  = '0';
        Character curr;
        String currStr = "1";
        String nextStr;
        int count = 1;
        for (int i = 0; i < n; i++) {
            int j = 0;
            nextStr = "";
            while (j != currStr.length()) {
                curr = currStr.charAt(j);
                if (prev == curr) {
                    count++;
                } else {
                    nextStr += Integer.toString(count) + Character.toString(prev);
                    count = 1;
                }
                prev = curr;
                j++;
            }
            currStr = nextStr;
        }
        return currStr;
    }
}
