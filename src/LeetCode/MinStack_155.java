import java.util.Stack;

/**
 * Created by xiaoxiao on 6/2/17.
 */
public class MinStack_155 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack_155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (x < min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
