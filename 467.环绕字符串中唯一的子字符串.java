/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */
import java.util.Arrays;
// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        int[] c = new int[26];
        int len = 1;
        c[p.charAt(0) - 'a'] = len;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z')) {
                len++;
            } else {
                len = 1;
            }
            c[p.charAt(i) - 'a'] = Math.max(c[p.charAt(i) - 'a'], len);
        }
        return Arrays.stream(c).sum();
    }
}
// @lc code=end

