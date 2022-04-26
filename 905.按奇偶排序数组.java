/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while((i < A.length && (A[i] & 1) == 0)) {
                i++;
            }
            while(j >= 0 && (A[j] & 1) == 1) {
                j--;
            }
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;j--;
            }
        }
        return A;
    }
}
// @lc code=end

