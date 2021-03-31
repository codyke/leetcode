package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 */

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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    Stack<NestedInteger> niStack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null && !nestedList.isEmpty()) {
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                niStack.push(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        NestedInteger ni = niStack.pop();
        return ni.getInteger();
    }

    @Override
    public boolean hasNext() {
        if (niStack.isEmpty()) {
            return false;
        }
        NestedInteger ni = niStack.peek();
        if (ni.isInteger()) {
            return true;
        } else {
            while(!ni.isInteger()) {
                ni = niStack.pop();
                List<NestedInteger> niList = ni.getList();
                for(int i = niList.size() - 1; i >= 0; i--) {
                    niStack.push(niList.get(i));
                }
                if (niStack.isEmpty()) {
                    return false;
                }
                ni = niStack.peek();
            }

            return true;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */