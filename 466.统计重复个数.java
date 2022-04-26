/*
 * @lc app=leetcode.cn id=466 lang=java
 *
 * [466] 统计重复个数
 */

// @lc code=start
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s2_index = 0;
        int s2_count = 0;
        int[] indexr = new int[n1];
        int[] countr = new int[n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) == s2.charAt(s2_index)) {
                    s2_index++;
                    if (s2_index == s2.length()) {
                        s2_index = 0;
                        s2_count++;
                    }
                }
            }
            indexr[i] = s2_index;
            countr[i] = s2_count;
            for (int k = 0; k < i; k++) {
                if (indexr[k] == indexr[i]) {
                    int prev_count = countr[k];
                    int pattern_count = (countr[i] - countr[k]) * ((n1 - (k + 1)) / (i - k));
                    int remain_count = countr[k + (n1 - (k + 1)) % (i - k)] - countr[k];
                    return (prev_count + pattern_count + remain_count) / n2;
                }
            }
        }
        return s2_count / n2;
    }
}
// @lc code=end

