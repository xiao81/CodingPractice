package LeetCode.WeeklyContest;

import java.util.*;

/**
 * Created by xiaoxiao on 7/8/17.
 */
public class WeeklyContest40 {
    public static void main(String[] args) {
        WeeklyContest40 weeklyContest40 = new WeeklyContest40();
        System.out.println(weeklyContest40.solveEquation("-x=-1"));

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Double> averageList = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            int totalNum = currSize;
            double sum = 0;
            while (currSize != 0) {
                TreeNode currNode = queue.poll();
                sum +=currNode.val/totalNum;
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                currSize -= 1;
            }
            averageList.add(sum);
        }
        return averageList;
    }

    public String solveEquation(String equation) {
        int leftCoefficient = 0;
        int leftConst = 0;
        String[] left = equation.split("=")[0].replace("-", "+-").split("\\+");
        String[] right = equation.split("=")[1].replace("-", "+-").split("\\+");

        for (int i = 0; i < left.length; i++) {
            String currString = left[i];
            boolean negative = false;
            if (currString.equals("")) continue;
            if (currString.contains("-")) {
                negative = true;
                currString = currString.replace("-", "");
            }
            if (currString.contains("x")) {
                currString = currString.replace("x","");
                if (currString.equals("")) {
                    currString = "1";
                }
                leftCoefficient+= negative ? -Integer.valueOf(currString) : Integer.valueOf(currString);
            } else {
                leftConst+= negative ? -Integer.valueOf(currString) : Integer.valueOf(currString);
            }

        }
        for (int i = 0; i < right.length; i++) {
            String currString = right[i];
            boolean negative = false;
            if (currString.equals("")) continue;
            if (currString.contains("-")) {
                negative = true;
                currString = currString.replace("-", "");
            }
            if (currString.contains("x")) {
                currString = currString.replace("x","");
                if (currString.equals("")) {
                    currString = "1";
                }
                leftCoefficient+= negative ? Integer.valueOf(currString) : -Integer.valueOf(currString);
            } else {
                leftConst+= negative ? Integer.valueOf(currString) : -Integer.valueOf(currString);
            }
        }

        if (leftCoefficient == 0 && leftConst == 0) {
            return "Infinite solutions";
        } else if (leftCoefficient == 0) {
            return "No solution";
        } else {
            leftConst /= leftCoefficient;
            return "x=" + -leftConst;
        }





    }


}
