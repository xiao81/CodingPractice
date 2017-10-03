package LeetCode.WeeklyContest;

import java.util.*;

/**
 * Created by xiaoxiao on 6/24/17.
 */
public class WeeklyContest38 {
    public static void main(String[] args) {
        WeeklyContest38 weeklyContest38 = new WeeklyContest38();

        System.out.println(weeklyContest38.maximumProduct(new int[]{1,2,3,4}));
        Excel excel = new Excel(5,'E');
        System.out.println(Arrays.deepToString(excel.matrix));
        excel.set(1,'A',1);
        System.out.println(Arrays.deepToString(excel.matrix));
        excel.sum(2,'B', new String[]{"A1"});
        System.out.println(Arrays.deepToString(excel.matrix));
        excel.set(2,'B',0);
        System.out.println(Arrays.deepToString(excel.matrix));
        excel.get(2,'B');
        System.out.println(Arrays.deepToString(excel.matrix));
        excel.set(1,'A',5);
        System.out.println(Arrays.deepToString(excel.matrix));
        excel.get(2,'B');
        System.out.println(Arrays.deepToString(excel.matrix));

    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] * nums[1] > nums[nums.length-2] * nums[nums.length-3]) {
            return nums[nums.length-1] * nums[0] * nums[1];
        } else {
            return nums[nums.length-1] * nums[nums.length-2] * nums[nums.length-3];
        }
    }
    public int scheduleCourse(int[][] courses) {
        int currDay = 1;
        int[] courseArr = new int[courses.length];
        while(true) {
            for (int i = 0; i < courseArr.length; i++) {
                if (courseArr[i] != -1) {

                }
            }
        }
    }
    public static class Excel {
        private int[][] matrix;
        private HashMap<String,Function> functions;

        public Excel(int H, char W) {
            matrix = new int[H][W-'A'+1];
            functions = new HashMap<>();
        }

        public void set(int r, char c, int v) {
            functions.remove(Integer.toString(r)+ Integer.toString(c));
            matrix[r-1][c-'A'] = v;
            if (!functions.isEmpty()) {
                for (Function function : functions.values()) {
                    sum(function.r,function.c,function.strs);
                }
            }


        }

        public int get(int r, char c) {
            System.out.println(matrix[r-1][c-'A']);
            return matrix[r-1][c-'A'];
        }

        public int sum(int r, char c, String[] strs) {
            int sum = 0;

            functions.put(Integer.toString(r)+ Integer.toString(c),new Function(r,c,strs));

            for (String string : strs) {
                if (!string.contains(":")) {
                    sum += sumMatrix(string,string);
                } else {
                    String[] stringSplit = string.split(":");
                    sum += sumMatrix(stringSplit[0],stringSplit[1]);
                }
            }
            matrix[r-1][c-'A'] = sum;

            return sum;
        }
        private int sumMatrix(String start, String end) {
            int sum = 0;
            for (int i = Integer.valueOf(start.substring(1)) -1; i<=Integer.valueOf(end.substring(1))-1; i++) {
                for (int j = Integer.valueOf(start.charAt(0)-'A'); j<=Integer.valueOf(end.charAt(0)-'A'); j++) {
                    sum +=matrix[i][j];
                }
            }
            return sum;
        }

        class Function {
            int r;
            char c;
            String[] strs;
            Function(int r, char c, String[] strs) {
                this.r = r;
                this.c = c;
                this.strs = strs;
            }
        }
    }
}
