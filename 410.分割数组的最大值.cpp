/*
 * @lc app=leetcode.cn id=410 lang=cpp
 *
 * [410] 分割数组的最大值
 */
#include<vector>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        int n = nums.size();
        vector<vector<unsigned int>> f(n + 1, vector<unsigned int>(m + 1, INT_MAX));
        vector<unsigned int> sub(n + 1);
        for (int i = 1; i <= n; i++)
        {
            sub[i] = sub[i - 1] + nums[i - 1];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                for (int k = 0; k < i; k++)
                {
                    f[i][j] = min(f[i][j], max(f[k][j - 1], sub[i] - sub[k]));
                }

            }

        }
        return f[n][m];

    }
};
// @lc code=end

