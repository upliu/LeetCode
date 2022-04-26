/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int N) {
        int max = 0;
        int cur = 0;
        boolean find1 = false;
        while(N > 0) {
            boolean is1 = (N & 1) == 1;
            if (find1) {
                cur++;
            }
            if (is1) {
                find1 = true;
                if (cur > max) {
                    max = cur;
                }
                cur = 0;
            }
            N = N >> 1;
        }
        return max;
    }
}
// @lc code=end

