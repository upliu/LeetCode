/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        return helper(arr, 0);
    }
    public int helper(int[] arr, int idx) {
        if (idx == arr.length) return 0;
        int min_index = idx;
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] < arr[min_index]) {
                min_index = i;
            }
        }
        return 1 + helper(arr, min_index + 1);
    }
}
// @lc code=end

