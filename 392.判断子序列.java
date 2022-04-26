/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int s_idx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(s_idx) == t.charAt(i)) {
                s_idx ++;
                if (s_idx == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

