package xyz.banjuer.csbase.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Offer30 {

    class MinStack {
        /**
         * 元素栈
         */
        Stack<Integer> s1;

        /**
         * 最小栈,栈顶为当前栈最小元素
         */
        Stack<Integer> s2;
        /** initialize your data structure here. */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
            if (s2.isEmpty()) {
                s2.push(x);
            } else {
                Integer peek = s2.peek();
                if (x < peek) {
                    s2.push(x);
                } else {
                    s2.push(peek);
                }
            }
        }

        public void pop() {
            s1.pop();
            s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
