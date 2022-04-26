/*
 * @lc app=leetcode.cn id=368 lang=cpp
 *
 * [368] 最大整除子集
 */
#include<vector>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        int max = 0;
        int end = -1;
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1);
        vector<int> prev(n, -1); // 下标的上一个数的下标
        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i < j; i++)
            {
                if (nums[j] % nums[i] == 0 && dp[j] <= dp[i]) {
                    dp[j] = dp[i] + 1;
                    prev[j] = i;
                }
            }
            if (dp[j] > max) {
                max = dp[j];
                end = j;
            }
        }
        vector<int> ans;
        for (int i = end; i != -1; i = prev[i])
        {
            ans.push_back(nums[i]);
        }
        reverse(ans.begin(), ans.end()); // leetcode 这里不管是否 reverse 都可以AC，搞不懂
        return ans;
    }
};
// @lc code=end

int main() {
    vector<int> ans;
    ans.push_back(1);
    ans.push_back(2);
    return 0;
}
