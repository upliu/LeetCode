/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while(n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
// @lc code=end

/*
2       CP
3       CPP
4       CPCP
5       CPPPP
6       CPPP
7       CPPPPPP
8       CPCPCP
9       CPPCPP
16      CPCPCPCP
32      CPCPCPCPCP
64      CPCPCPCPCPCP
128     CPCPCPCPCPCPCP
256     CPCPCPCPCPCPCPCP
512     CPCPCPCPCPCPCPCPCP
1024    CPCPCPCPCPCPCPCPCPCP
*/
