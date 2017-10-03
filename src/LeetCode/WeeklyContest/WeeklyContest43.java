package LeetCode.WeeklyContest;

public class WeeklyContest43 {
    public static void main(String[] args) {
        WeeklyContest43 weeklyContest43 = new WeeklyContest43();
        System.out.println(weeklyContest43.minSteps(1));//0
        System.out.println(weeklyContest43.minSteps(2));//2
        System.out.println(weeklyContest43.minSteps(3));//3
        System.out.println(weeklyContest43.minSteps(4));//4
        System.out.println(weeklyContest43.minSteps(5));//5
        System.out.println(weeklyContest43.minSteps(6));//5
        System.out.println(weeklyContest43.minSteps(9));//6
        System.out.println(weeklyContest43.minSteps(10));//7
        System.out.println(weeklyContest43.minSteps(12));//7
        System.out.println(weeklyContest43.minSteps(25));//10

        System.out.println("MaxA");
        System.out.println(weeklyContest43.maxA(7));
        System.out.println(weeklyContest43.maxA(8));
        System.out.println(weeklyContest43.maxA(9));
        System.out.println(weeklyContest43.maxA(11));
    }
    public int minSteps(int n) {
        int count = 0;
        int curr = n;
        int factor = n;
        while (findIfDivisible(curr)) {
            if (curr % factor == 0 && factor != curr) {
                if (curr == factor * 2) count +=2;
                else count ++;
                curr -= factor;
            } else {
                factor--;
            }

        }
        if (curr == 1) return count;
        else return count + curr;

    }
    private boolean findIfDivisible(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return true;
        }
        return false;
    }

    public int maxA(int N) {
        if (N < 7) return N;
        int total = N - 2;
        int max = N;
        for (int i = 1; i < total; i++) {
            max = Math.max(max, i * (total - i + 1));
        }
        return max;
    }

}
