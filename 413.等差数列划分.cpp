/*
 * @lc app=leetcode.cn id=413 lang=cpp
 *
 * [413] 等差数列划分
 */
#include<vector>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        int n = A.size();
        if (n <= 2) return 0;
        int diff = A[1] - A[0]; // 最后的差
        int lastcnt = 2; // 等差数字个数
        int ans = 0;
        for (int i = 2; i < n; i++)
        {
            int newdiff = A[i] - A[i - 1];
            if (diff == newdiff) {
                lastcnt++;
                if (lastcnt >= 3) {
                    ans += lastcnt - 2;
                }
            } else {
                diff = newdiff;
                lastcnt = 2;
            }
        }
        return ans;
    }
};
// @lc code=end

