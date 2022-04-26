/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end

