/*
 * @lc app=leetcode.cn id=312 lang=cpp
 *
 * [312] 戳气球
 */
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> dp = vector<vector<int>>(n + 2, vector<int>(n + 2 , 0));
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                int numsi = i - 2 >= 0 ? nums[i - 2] : 1;
                int numsj = j <= n - 1 ? nums[j] : 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + nums[k - 1] * numsi * numsj);
                }
            }
        }
        return dp[1][n];
    }
};
// @lc code=end

