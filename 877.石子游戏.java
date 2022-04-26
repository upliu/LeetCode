/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    public boolean stoneGame(int[] piles) {
        int[] sum = new int[piles.length + 1];
        for (int i = 1; i <= piles.length; i++) {
            sum[i] = sum[i - 1] + piles[i - 1];
        }
        int[][] dp = new int[piles.length][piles.length];
        // dp[i][j] 表示 i,j 先手最多能拿到的数量
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                int a = sum[j] - sum[i] - dp[i][j - 1] + piles[j];
                int b = sum[j + 1] - sum[i + 1] - dp[i + 1][j] + piles[i];
                dp[i][j] = Math.max(a, b);
            }
        }
        return dp[0][piles.length - 1] > sum[piles.length] / 2;
    }
}
// @lc code=end

