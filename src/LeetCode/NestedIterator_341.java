import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoxiao on 5/29/17.
 */
public class NestedIterator_341 implements Iterator<Integer> {
    static class NestedInteger {
        public boolean isInteger() {
            return true;
        }
        public Integer getInteger() {
            return 0;
        }
        public List<NestedInteger> getList() {
            return new LinkedList<>();
        }
    }
    private Queue<Integer> queue = new LinkedList<>();
    public NestedIterator_341(List<NestedInteger> nestedList) {
        helper(nestedList);
    }
    public void helper(List<NestedInteger> nestedList) {
        for (int i =0; i < nestedList.size();i++) {
            if (nestedList.get(i).isInteger()) {
                queue.offer(nestedList.get(i).getInteger());
            } else {
                helper(nestedList.get(i).getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
