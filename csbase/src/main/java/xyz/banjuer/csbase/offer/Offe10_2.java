package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 *
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。


 */
public class Offe10_2 {

    /**
     * n台阶有f(n-1) + f(n-2)种跳法
     */
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
            b %= 1000000007;
        }
        return b;
    }

}
