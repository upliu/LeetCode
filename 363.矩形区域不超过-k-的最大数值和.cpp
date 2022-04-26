/*
 * @lc app=leetcode.cn id=363 lang=cpp
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */
#include<vector>
#include<algorithm>
#include<set>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> v(m + 1, vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                v[i][j] = matrix[i - 1][j - 1] + v[i][j - 1]; // i行1列到i行j列的和
            }
        }
        for (int l = 0; l < n; l++)
        {
            for (int r = l; r < n; r++)
            {
                set<int> s;
                
            }
            
        }
        
        
    }
};
// @lc code=end

