package xyz.banjuer.csbase.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer10_1 {

    /**
     * 原始递归
     */
    public int fib0(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * 加入记忆化搜索,避免重复计算
     * 自顶向下
     */
    private int[] mem;
    public int fib1(int n) {
        // 递归截止
        if (n == 0) return 0;
        if (n == 1) return 1;
        // 初始记忆集,n为索引位
        if (mem == null) {
            mem = new int[n + 1];
            Arrays.fill(mem, -1);
        }
        if (mem[n] == -1) {
            mem[n] = (fib1(n - 1) + fib1(n - 2)) % 1000000007;
        }
        return mem[n];
    }

    /**
     * 动态规划
     * 自底向上
     */
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int[] mem = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            mem[i] = (mem[i - 1] + mem[i - 2]) % 1000000007;
        }
        return mem[n];
    }

    /**
     * 动态规划
     * 自底向上
     */
    public int fib3(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            b = (a + b) % 1000000007;
            a = b ;
        }
        return b;
    }

}
