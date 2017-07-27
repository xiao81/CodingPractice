package LeetCode;

import java.util.*;

public class KillProcess_582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new LinkedList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }

        queue.offer(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            if (map.containsKey(curr)) {
                for (int id : map.get(curr)) {
                    queue.add(id);
                }
            }
        }
        return result;
    }
}
