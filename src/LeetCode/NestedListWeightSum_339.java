package LeetCode;

import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
public class NestedListWeightSum_339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumHelper(1, nestedList);
    }

    public int depthSumHelper(int depth, List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += depthSumHelper(depth + 1, nestedInteger.getList());
            }
        }
        return sum;
    }
}
