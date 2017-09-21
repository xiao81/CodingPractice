package Assignments;

import javax.xml.transform.Result;
import java.util.*;

public class Assignment5 {
    public static void main(String[] args) {
        Assignment5 assignment5 = new Assignment5();
        int[][] arr = new int[][]{{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        System.out.println(Arrays.toString(assignment5.mergeKSortedArrays(arr)));
        System.out.println(assignment5.connectRopes(new int[]{4,3,2,6}));

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());

    }

    //Q1
    public int[] mergeKSortedArrays(int[][] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        if (arr[0] == null || arr[0].length == 0) return new int[0];

        PriorityQueue<ResultType> pq = new PriorityQueue<>((x,y) -> (x.value - y.value));
        int k = arr.length;
        int n = arr[0].length;
        int[] result = new int[k*n];
        int i = 0;
        for (int j = 0; j < k; j++) {
            pq.offer(new ResultType(0, j, arr[j][0]));
        }

        while (i != result.length) {
            ResultType curr = pq.poll();
            result[i++] = curr.value;
            if (curr.index + 1 < n) {
                pq.offer(new ResultType(curr.index + 1, curr.indexArr, arr[curr.indexArr][curr.index + 1]));
            }
        }

        return result;
        }
    class ResultType {
        int index;
        int indexArr;
        int value;
        ResultType(int index, int indexArr, int value) {
            this.index = index;
            this.indexArr = indexArr;
            this.value = value;
        }
    }

    //Q2
    //Heap sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> (y.getValue() - x.getValue()));
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
        }
        for (int i = 0; i < k; i++) result.add(pq.poll().getKey());
        return result;
    }

    //Bucket sort
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }

    //Q3
    static class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minHeap.size() == 0 || maxHeap.size() == 0) minHeap.offer(num);
            else {
                if (num > minHeap.peek()) maxHeap.offer(num);
                else minHeap.offer(num);
            }

            if (minHeap.size() - maxHeap.size() >= 2) maxHeap.offer(minHeap.poll());
            if (maxHeap.size() - minHeap.size() >= 2) minHeap.offer(maxHeap.poll());
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (double)(minHeap.peek() + maxHeap.peek()) / 2;
            } else {
                return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
            }
        }
    }

    //Q4
    public void sortK(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        int j = 0;
        for (i = 0; i <= k; i ++) pq.offer(arr[i]);
        while (!pq.isEmpty()) {
            if (i < arr.length) pq.offer(arr[i++]);
            arr[j++] = pq.poll();
        }
    }

    //Q5
    public int connectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) pq.offer(rope);
        int sum = 0;
        while (pq.size() > 1) {
            int value = pq.poll() + pq.poll();
            sum += value;
            pq.offer(value);
        }
        return sum;
    }
}
