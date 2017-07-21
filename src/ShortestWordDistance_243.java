
public class ShortestWordDistance_243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
            } else if (word2.equals(words[i])) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(Math.abs(index1 - index2), min);
            }

        }
        return min;
    }
}
