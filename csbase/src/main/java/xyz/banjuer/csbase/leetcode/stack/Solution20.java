package xyz.banjuer.csbase.leetcode.stack;

import java.util.Stack;

public class Solution20 {

    /**
     * 20. 有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            // 当是右括号时，弹出栈顶元素与之匹配
            if (isRightBrackets(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (!matchLeft(left, c)) {
                    return false;
                }
            }
            // 当是左括号入栈
            if (isLeftBrackets(c)) {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean matchLeft(char l, char r) {
        return (l == '{' && r == '}') || (l == '(' && r == ')') || (l == '[' && r == ']');
    }

    private boolean isLeftBrackets(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isRightBrackets(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        // String s = "()";
        // String s = "()[]{}";
        // String s = "(]";
        String s = "([)]";
        System.out.println(solution20.isValid(s));
    }

}
