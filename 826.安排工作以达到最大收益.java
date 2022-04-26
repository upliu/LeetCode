import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        for(int w : worker) {
            int max = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (w >= difficulty[i] && profit[i] > max) {
                    max = profit[i];
                }
            }
            ans += max;
        }
        return ans;
    }
}
// @lc code=end

/*
int ans = 0;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for(int w : worker) {
            int max = 0;
            for (int i = 0; i < difficulty.length; i++) {
                if (w >= difficulty[i] && profit[i] > max) {
                    max = profit[i];
                }
            }
            ans += max;
        }
        return ans;
Accepted
57/57 cases passed (1134 ms)
Your runtime beats 7.08 % of java submissions
Your memory usage beats 14.93 % of java submissions (42.4 MB)
*/