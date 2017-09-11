package BrightEdgeOnsite;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MedianFinder {

    /** initialize your data structure here. */
    private LinkedList<Integer> list;
    public MedianFinder() {
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Collections.sort(list);
        int i = 0;
        while (i != list.size()/2) i++;
        if (list.size() % 2  != 0) {
            return list.get(i);
        } else {
            return (double)(list.get(i) + list.get(i-1))/2;
        }
    }
    public boolean judgeCircle(String moves) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < moves.length(); i++) {
            char currChar = moves.charAt(i);
            if (currChar == 'U') count1++;
            else if (currChar == 'D') count1--;
            else if (currChar == 'L') count2++;
            else if (currChar == 'R') count2--;
        }
        return count1 == 0 && count2 == 0;
    }
}
