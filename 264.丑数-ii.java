/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;
        int idx1, idx2, idx3;
        idx1 = idx2 = idx3 = 0;
        for (int i = 1; i < n; i++) {
            int a = ugly[idx1] * 2;
            int b = ugly[idx2] * 3;
            int c = ugly[idx3] * 5;
            ugly[i] = Math.min(a, Math.min(b, c));
            if (ugly[i] == a) idx1++;
            if (ugly[i] == b) idx2++;
            if (ugly[i] == c) idx3++;
        }
        return ugly[n - 1];
    }
}
// @lc code=end

