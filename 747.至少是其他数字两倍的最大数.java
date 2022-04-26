/*
 * @lc app=leetcode.cn id=747 lang=java
 *
 * [747] 至少是其他数字两倍的最大数
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int max = nums[0];
        int max_idx = 0;
        int second_max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                second_max = max;
                max = nums[i];
                max_idx = i;
            } else if (nums[i] > second_max) {
                second_max = nums[i];
            }
        }
        if (max >= second_max * 2) return max_idx;
        return -1;
    }
}
// @lc code=end

