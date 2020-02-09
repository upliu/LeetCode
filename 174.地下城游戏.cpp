/*
 * @lc app=leetcode.cn id=174 lang=cpp
 *
 * [174] 地下城游戏
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        if (dungeon.empty()) return 0;
        int row = dungeon.size();
        int col = dungeon[0].size();
        vector<vector<int>> dp(row, vector<int>(col, 0)); // dp[i][j] 代表i行j列格子走到右下角需要的最低血量
        dp[row - 1][col - 1] = dungeon[row - 1][col - 1] > 0 ? 1 : -dungeon[row - 1][col - 1] + 1;
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = dungeon[row - 1][i] >= dp[row - 1][i + 1] ? 1 : dp[row - 1][i + 1] - dungeon[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = dungeon[i][col - 1] >= dp[i + 1][col - 1] ? 1 : dp[i + 1][col - 1] - dungeon[i][col - 1];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                 // 找出右面和下面格子中所需血量的较小者，与当前格子血量比较，比较是否需要系统补血，
                dp[i][j] = (dungeon[i][j] >= min(dp[i][j + 1], dp[i + 1][j])) ? 1
                        : min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
            }
        }
        return dp[0][0];
    }
};
// @lc code=end

