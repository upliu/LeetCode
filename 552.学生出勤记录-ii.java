/*
 * @lc app=leetcode.cn id=552 lang=java
 *
 * [552] 学生出勤记录 II
 */

// @lc code=start
class Solution {
    int count,M=1000000007;
    public int checkRecord(int n) {
        count = 0;
        gen("", n);
        return count;
    }
    public void gen(String s, int n) {
        if (n == 0 && check(s)) {
            count = (count + 1) % M;
        } else if (n > 0) {
            gen(s + "A", n - 1);
            gen(s + "P", n - 1);
            gen(s + "L", n - 1);
        }
    }
    public boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') count++;
        }
        return s.length() > 0 && count < 2 && s.indexOf("LLL") < 0;
    }
}
// @lc code=end

