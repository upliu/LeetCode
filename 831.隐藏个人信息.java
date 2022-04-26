/*
 * @lc app=leetcode.cn id=831 lang=java
 *
 * [831] 隐藏个人信息
 */

// @lc code=start
class Solution {
    public String maskPII(String S) {
        int at_idx = S.indexOf("@");
        if (at_idx != -1) { // 邮箱
            return (S.substring(0, 1) + "*****" + S.substring(at_idx - 1)).toLowerCase();
        }
        String digits = S.replaceAll("\\D+", "");
        String local = "***-***-" + digits.substring(digits.length() - 4);
        if (digits.length() == 10) return local;
        String ans = "+";
        for (int i = 0; i < digits.length() - 10; i++) {
            ans += "*";
        }
        return ans + "-" + local;
    }
}
// @lc code=end

