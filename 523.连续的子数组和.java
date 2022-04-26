/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = sum[j + 1] - sum[i];
                if (k == 0) {
                    if (tmp == 0) return true;
                } else {
                    if (tmp % k == 0) return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

