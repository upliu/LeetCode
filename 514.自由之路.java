/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
//动态规划
//dp[i][j]，key的0~i位字符拼写后，ring的第j位对齐12：00方向，需要的最小步数
//前提：key[i] = ring[j]，若不满足，dp[i][j] = INT_MAX
        int m = ring.length();
        int n = key.length();
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            if (ring.charAt(j) == key.charAt(0)) {
                dp[0][j] = Math.min(j, m - j) + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (key.charAt(i) != ring.charAt(j)) continue;
                for (int k = 0; k < m; k++) {
                    if (ring.charAt(k) != key.charAt(i - 1)) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min((j - k + m) % m, (k - j + m) % m) + 1);
                }
            }
        }
        int mincost = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            if (ring.charAt(j) == key.charAt(n - 1)) {
                mincost = Math.min(mincost, dp[n - 1][j]);
            }
        }
        return mincost;
    }
}
// @lc code=end

