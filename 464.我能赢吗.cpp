/*
 * @lc app=leetcode.cn id=464 lang=cpp
 *
 * [464] 我能赢吗
 */
#include<vector>
#include<algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<int> dp;
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        dp = vector<int>(1 << maxChoosableInteger);
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;
        if (sum == desiredTotal) {
            if ((maxChoosableInteger & 1) == 1) {
                return true;
            }
            return false;
        }
        return canIWin(0, desiredTotal, maxChoosableInteger);
    }

    bool canIWin(int bits, int distance, int maxChoosableInteger) {
        if (dp[bits] != 0) {
            return dp[bits] == 1;
        }
        bool ret = false;
        for (int cur = maxChoosableInteger; cur > 0; cur--)
        {
            int curBit = 1 << (cur - 1);
            if ((bits & curBit) == 0) {
                if (cur >= distance || !canIWin(bits | curBit, distance - cur, maxChoosableInteger)) {
                    ret = true;
                    break;
                }
            }
        }
        dp[bits] = ret ? 1 : 2;
        return ret;
    }
};
// @lc code=end

