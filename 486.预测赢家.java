/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] A = new int[n][n]; // 先手玩家能获得的最大分数
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            A[i][i] = nums[i];
        }
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int s = n - 1; s >= 0; s--) {
            for (int e = s + 1; e < n; e++) {
                A[s][e] = Math.max(
                    nums[s] + sum[e + 1] - sum[s + 1] - A[s + 1][e]
                ,   nums[e] + sum[e] - sum[s] - A[s][e - 1]);
            }
        }
        return A[0][n - 1] * 2 >= sum[n];
    }

    public boolean PredictTheWinner1(int[] nums) {
        return winner(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int winner(int[] nums, int s, int e, int turn) {
        if (s == e) {
            return turn * nums[s];
        }
        int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
        int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
    }
}
// @lc code=end

