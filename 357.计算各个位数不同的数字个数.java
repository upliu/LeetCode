/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int prev = 9;
        int ans = 10;
        for(int i = 2; i <= n; i++) {
            prev = prev * (11 - i);
            ans += prev;
        }
        return ans;
    }
}
// @lc code=end

