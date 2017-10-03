package LeetCode.WeeklyContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 7/15/17 Coding Contest
 */
public class WeeklyContest41 {
    public static void main(String[] args) {
        WeeklyContest41 weeklyContest41 = new WeeklyContest41();
        System.out.println(weeklyContest41.findMaxAverage(new int[]{9,7,3,5,6,2,0,8,1,9},6));
        System.out.println(weeklyContest41.findMaxAverage(new int[]{-1},1));
        System.out.println(Arrays.toString(weeklyContest41.exclusiveTime(2, new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")))));
        System.out.println(Arrays.toString(weeklyContest41.exclusiveTime(1, new ArrayList<>(Arrays.asList("0:start:0", "0:end:0")))));
        System.out.println(Arrays.toString(weeklyContest41.exclusiveTime(1, new ArrayList<>(Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")))));

    }
    public double findMaxAverage(int[] nums, int k) {
        double max = -Double.MAX_VALUE;
        double count = 0;
        for (int j = 0; j < k; j++){
            count += (double)nums[j]/(double)k;
        }
        max = Math.max(max, count);
        for (int i = k; i < nums.length; i++){
            count -= (double)nums[i-k]/(double)k;
            count += (double)nums[i]/(double)k;
            max = Math.max(max, count);
        }
        return max;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] resultList = new int[n];
        int prevEnd = Integer.MIN_VALUE;
        int prevStart =Integer.MIN_VALUE;
        for (String log : logs) {
            String[] logArray =log.split(":");
            int num = Integer.valueOf(logArray[0]);
            int timestamp = Integer.valueOf(logArray[2]);
            String operation = logArray[1];
            if (operation.equals("start")) {
                if (prevStart != Integer.MIN_VALUE){
                    resultList[stack.peek()[0]] += timestamp - stack.peek()[1];
                }
                if (prevEnd != Integer.MIN_VALUE && !stack.isEmpty()){
                    resultList[stack.peek()[0]] += timestamp - prevEnd - 1;
                }
                stack.push(new int[]{num, timestamp});
                prevStart = timestamp;
                prevEnd = Integer.MIN_VALUE;
            } else {
                if (prevEnd != Integer.MIN_VALUE) {
                    resultList[num] += timestamp - prevEnd;
                    stack.pop();
                }
                if (prevStart != Integer.MIN_VALUE){
                    resultList[num] += timestamp - stack.pop()[1] + 1;
                }
                prevStart = Integer.MIN_VALUE;
                prevEnd = timestamp;
            }
        }

        return resultList;
    }
}
