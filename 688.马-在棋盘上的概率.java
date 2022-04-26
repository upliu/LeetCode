/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] “马”在棋盘上的概率
 */

// @lc code=start
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N]; // 从 (r, c) 走k步后落在棋盘位置 (i, j) 处的概率
        dp[0][r][c] = 1.0; // 走0步落在 (r, c) 概率为1
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double D1 = (i >= 1 && j >= 2) ? dp[k - 1][i - 1][j - 2] : 0;
                    double D2 = (i >= 2 && j >= 1) ? dp[k - 1][i - 2][j - 1] : 0;
                    double D3 = (i >= 2 && j < N - 1) ? dp[k - 1][i - 2][j + 1] : 0;
                    double D4 = (i >= 1 && j < N - 2) ? dp[k - 1][i - 1][j + 2] : 0;
                    double D5 = (i < N - 1 && j >= 2) ? dp[k - 1][i + 1][j - 2] : 0;
                    double D6 = (i < N - 2 && j >= 1) ? dp[k - 1][i + 2][j - 1] : 0;
                    double D7 = (i < N - 2 && j < N - 1) ? dp[k - 1][i + 2][j + 1] : 0;
                    double D8 = (i < N - 1 && j < N - 2) ? dp[k - 1][i + 1][j + 2] : 0;
                    dp[k][i][j] = (D1 + D2 + D3 + D4 + D5 + D6 + D7 + D8) / 8.0;
                }
            }
        }
        double res=0;
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                res+=dp[K][i][j];
            }
        return res;
    }
}
// @lc code=end

// 0 1 2 3 4 5
0 2 4 6 8 10
// 0 1 2 3 4
0 2 4 6 8