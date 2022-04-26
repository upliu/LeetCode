/*
 * @lc app=leetcode.cn id=517 lang=java
 *
 * [517] 超级洗衣机
 */

// @lc code=start
class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int total = 0;
        for(int m : machines) total += m;
        if (total % n != 0) return -1;
        int avg = total / n;
        for (int i = 0; i < n; i++) {
            machines[i] -= avg;
        }
        int currSum = 0, maxSum = 0, res = 0;
        for(int m : machines) {
            currSum += m;
            maxSum = Math.max(maxSum, Math.abs(currSum));
            res = Math.max(res, Math.max(maxSum, m));
        }
        return res;
    }
}
// @lc code=end

