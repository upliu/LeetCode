/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] memo = new int[A.length + 1][B.length + 1];
        int ans = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (memo[i][j] > ans) {
                        ans = memo[i][j];
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

