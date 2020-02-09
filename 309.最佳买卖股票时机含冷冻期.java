/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int[] hold = new int[n];
        int[] notHold = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], (i - 2 >= 0 ? notHold[i - 2] : 0) - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i]);
        }
        return notHold[n - 1];
    }
}
// @lc code=end

