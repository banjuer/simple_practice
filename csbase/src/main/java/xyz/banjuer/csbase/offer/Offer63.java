package xyz.banjuer.csbase.offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Offer63 {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price: prices) {
            cost = Math.min(cost, price);
            // 最大利润为当前利润或者历史最大利润
            profit = Math.max(price - cost, profit);
        }
        return profit;
    }

}
