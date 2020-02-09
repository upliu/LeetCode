/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    private int[][] dp;

    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        int numsi = i - 1 >= 0 ? nums[i - 1] : 1;
        int numsj = j + 1 < nums.length ? nums[j + 1] : 1;
        for (int k = i; k <= j; k++) {
            int left = helper(nums, i, k - 1);
            int right = helper(nums, k + 1, j);
            dp[i][j] = Math.max(dp[i][j], left + right + nums[k] * numsi * numsj);
        }
        return dp[i][j];
    }
}
// @lc code=end

