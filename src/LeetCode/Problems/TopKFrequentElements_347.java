package LeetCode.Problems;

import java.util.*;

/**
 * Created by xiaoxiao on 4/27/17.
 */
public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        TopKFrequentElements_347 t = new TopKFrequentElements_347();
        System.out.println(t.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 3));
    }
    static class Node {
        int val;
        int freq;
        Node (int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> returnList = new LinkedList<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Node> frequencyHeap = new PriorityQueue<>((x,y)->(y.freq-x.freq));
        for (int key : frequencyMap.keySet()) {
            frequencyHeap.offer(new Node(key, frequencyMap.get(key)));
        }
        for (int i = 0; i < k; i++) {
            returnList.add(frequencyHeap.poll().val);
        }
        return returnList;


    }

}
