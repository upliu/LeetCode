/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) return new int[]{0, 0};
        int remain = 100;
        int row_cnt = 1;
        for (int i = 0; i < S.length(); i++) {
            int need = widths[S.charAt(i) - 'a'];
            if (need > remain) {
                row_cnt++;
                remain = 100;
            }
            remain -= need;
        }
        return new int[]{row_cnt, 100 - remain};
    }
}
// @lc code=end

