package xyz.banjuer.csbase.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class Solution341 {

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


    /**
     * 341. 扁平化嵌套列表迭代器
     *
     * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
     *
     * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public class NestedIterator implements Iterator<Integer> {

        private Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new ArrayDeque<>();
            enqueue(nestedList);
        }

        private void enqueue(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                boolean b = nestedInteger.isInteger();
                if (b) {
                    queue.add(nestedInteger.getInteger());
                } else {
                    List<NestedInteger> list = nestedInteger.getList();
                    enqueue(list);
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

}
