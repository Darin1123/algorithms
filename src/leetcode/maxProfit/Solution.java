package leetcode.maxProfit;

/**
 * @author Zefeng Wang
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int preMin = prices[0];
        int profit = 0;
        for (int price : prices) {
            profit = Math.max(price - preMin, profit);
            preMin = Math.min(preMin, price);
        }

        return profit;
    }
}
