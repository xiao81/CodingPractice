import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoxiao on 7/1/17.
 */
public class WeeklyContest39 {
    public static void main(String[] args) {
        WeeklyContest39 weeklyContest39 = new WeeklyContest39();
        System.out.println(weeklyContest39.judgeSquareSum(100));

    }
    public boolean judgeSquareSum(int c) {
        double curr = Math.sqrt(c);
        double rest = 0;
        while (curr != -1) {
            if (Math.sqrt(curr) % 1 == 0 && Math.sqrt(rest) % 1 == 0) {
                return true;
            } else {
                curr-=1;
                rest+=1;
            }
        }

        return false;
    }
    class LogSystem {
        private HashMap<Integer, Stamp> timeMap;
        public LogSystem() {
            timeMap = new HashMap<>();
        }

        public void put(int id, String timestamp) {
            timeMap.put(id, convertToStamp(timestamp));
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            Stamp start = convertToStamp(s);
            Stamp end = convertToStamp(e);
            Stamp curr;
            List<Integer> result = new LinkedList<>();
            int index = 0;

            switch (gra) {
                case "Year": index = 0;break;
                case "Month": index = 1;break;
                case "Day": index = 2;break;
                case "Hour": index = 3;break;
                case "Minute": index = 4;break;
                case "Second": index = 5;break;
            }

            for (int key : timeMap.keySet()) {
                curr = timeMap.get(key);
                switch (index) {
                    case 0:
                        if (curr.timeList[0] >= start.timeList[0] && curr.timeList[0] <= end.timeList[0]) {
                            result.add(key);
                        }
                        break;
                    case 1:
                        if ((curr.timeList[0] >= start.timeList[0] && curr.timeList[0] <= end.timeList[0]) &&
                        (curr.timeList[1] >= start.timeList[1] && curr.timeList[1] <= end.timeList[1])) {
                                result.add(key);
                            }
                        break;
                    case 2:
                        if ((curr.timeList[0] >= start.timeList[0] && curr.timeList[0] <= end.timeList[0]) &&
                                (curr.timeList[1] >= start.timeList[1] && curr.timeList[1] <= end.timeList[1]) &&
                                (curr.timeList[2] >= start.timeList[2] && curr.timeList[2] <= end.timeList[2])) {
                                result.add(key);
                            }
                        break;
                    case 3:
                        if ((curr.timeList[0] >= start.timeList[0] && curr.timeList[0] <= end.timeList[0]) &&
                                (curr.timeList[1] >= start.timeList[1] && curr.timeList[1] <= end.timeList[1]) &&
                                (curr.timeList[2] >= start.timeList[2] && curr.timeList[2] <= end.timeList[2]) &&
                                (curr.timeList[3] >= start.timeList[3] && curr.timeList[3] <= end.timeList[3])) {
                            result.add(key);
                        }
                        break;
                    case 4:
                        if ((curr.timeList[0] >= start.timeList[0] && curr.timeList[0] <= end.timeList[0]) &&
                                (curr.timeList[1] >= start.timeList[1] && curr.timeList[1] <= end.timeList[1]) &&
                                (curr.timeList[2] >= start.timeList[2] && curr.timeList[2] <= end.timeList[2]) &&
                                (curr.timeList[3] >= start.timeList[3] && curr.timeList[3] <= end.timeList[3]) &&
                                (curr.timeList[4] >= start.timeList[4] && curr.timeList[4] <= end.timeList[4])) {
                            result.add(key);
                        }
                        break;
                    case 5:
                        if ((curr.timeList[0] >= start.timeList[0] && curr.timeList[0] <= end.timeList[0]) &&
                                (curr.timeList[1] >= start.timeList[1] && curr.timeList[1] <= end.timeList[1]) &&
                                (curr.timeList[2] >= start.timeList[2] && curr.timeList[2] <= end.timeList[2]) &&
                                (curr.timeList[3] >= start.timeList[3] && curr.timeList[3] <= end.timeList[3]) &&
                                (curr.timeList[4] >= start.timeList[4] && curr.timeList[4] <= end.timeList[4]) &&
                                (curr.timeList[5] >= start.timeList[5] && curr.timeList[5] <= end.timeList[5])) {
                            result.add(key);
                        }
                        break;

                }
            }

        return result;
        }

        private Stamp convertToStamp(String timestamp) {
            //Year:Month:Day:Hour:Minute:Second
            String[] timeString = timestamp.split(":");
            int sec = Integer.valueOf(timeString[5]);
            int min = Integer.valueOf(timeString[4]);
            int hr = Integer.valueOf(timeString[3]);
            int day = Integer.valueOf(timeString[2]);
            int mon = Integer.valueOf(timeString[1]);
            int year = Integer.valueOf(timeString[0]);
            return new Stamp(sec, min, hr, day, mon, year);
        }
        class Stamp {
            int[] timeList = new int[6];

            public Stamp(int sec, int min, int hr, int day, int mon, int year) {
                timeList[0] = year;
                timeList[1] = mon;
                timeList[2] = day;
                timeList[3] = hr;
                timeList[4] = min;
                timeList[5] = sec;
            }
        }
    }

}
