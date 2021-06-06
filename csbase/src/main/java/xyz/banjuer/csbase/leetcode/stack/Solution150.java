package xyz.banjuer.csbase.leetcode.stack;

import java.util.Stack;

public class Solution150 {

    /**
     * 150. 逆波兰表达式求值
     * <p>
     * 根据 逆波兰表示法，求表达式的值。
     * <p>
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * <p>
     *  
     * <p>
     * 说明：
     * <p>
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("*".equals(token)) {
                Integer _1 = Integer.parseInt(stack.pop());
                Integer _2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(_2 * _1));
            } else if ("+".equals(token)) {
                Integer _1 = Integer.parseInt(stack.pop());
                Integer _2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(_2 + _1));
            } else if ("-".equals(token)) {
                Integer _1 = Integer.parseInt(stack.pop());
                Integer _2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(_2 - _1));
            } else if ("/".equals(token)) {
                Integer _1 = Integer.parseInt(stack.pop());
                Integer _2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(_2 / _1));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Solution150 solution150 = new Solution150();
        // String[] tokens = new String[]{"2","1","+","3","*"};
        // String[] tokens = new String[]{"4","13","5","/","+"};
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        // String[] tokens = new String[]{};
        System.out.println(solution150.evalRPN(tokens));
    }

}
