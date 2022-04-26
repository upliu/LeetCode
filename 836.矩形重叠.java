/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 */

// @lc code=start
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return helper(rec1[0], rec1[2], rec2[0], rec2[2])
        && helper(rec1[1], rec1[3], rec2[1], rec2[3]);
    }
    public boolean helper(int x1, int x2, int x3, int x4) {
        return (x2 > x4 ? (x2 - x3) : (x4 - x1)) + x1 + x3 < x2 + x4;
    }
}
// @lc code=end

