/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }
    public void dfs(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (S == sum) {
                count ++;
            }
        } else {
            dfs(nums, i + 1, sum - nums[i], S);
            dfs(nums, i + 1, sum + nums[i], S);
        }
    }
}
// @lc code=end

