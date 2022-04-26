/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int max = 0;
        int end = -1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                end = i;
            }
        }
        for (int i = end; i != -1; i = prev[i]) {
            ans.add(nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
// @lc code=end

