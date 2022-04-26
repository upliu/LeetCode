/*
 * @lc app=leetcode.cn id=446 lang=cpp
 *
 * [446] 等差数列划分 II - 子序列
 */
#include<vector>
#include<algorithm>
using namespace std;
// @lc code=start
#define LL long long int
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        int n = A.size();
        LL ans = 0;
        vector<map<LL, int>> dp(n);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                LL delta = (LL)A[i] - (LL)A[j];
                int sum = 0;
                if (dp[j].find(delta) != dp[j].end()) {
                    sum = dp[j][delta];
                }
                dp[i][delta] += sum + 1;
                ans += sum;
            }
            
        }
        
        return (int)ans;
    }
};
// @lc code=end

