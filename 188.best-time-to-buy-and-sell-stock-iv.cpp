/*
 * @lc app=leetcode id=188 lang=cpp
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if(prices.empty()) return 0;
        int ans = 0;
        if(k >= prices.size() / 2){
            for(int i = 1; i < prices.size(); ++i){
                if(prices[i] > prices[i - 1])
                    ans += prices[i] - prices[i - 1];
            }
            return ans;
        }
        vector<vector<int>> dp(prices.size(), vector<int>(k + 1, 0));
        for(int x = 1; x <= k; ++x){
            for(int i = 1; i < prices.size(); ++i){
                dp[i][x] = dp[i - 1][x]; // 不做交易
                for(int j = 0; j < i; ++j){
                    dp[i][x] = max(dp[i][x], dp[j][x - 1] + prices[i] - prices[j]);
                }
            }
            ans = max(ans, dp[prices.size() - 1][x]);
        }
        return ans;
    }
};
// @lc code=end

