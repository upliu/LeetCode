/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for (int x : nums) {
            int low = 0, high = maxLength;
            while (low < high) {
                int mid = (low + high) / 2;
                if (dp[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            dp[low] = x;
            if (low == maxLength) {
                maxLength ++;
            }
        }
        return maxLength;
    }
}
// @lc code=end

