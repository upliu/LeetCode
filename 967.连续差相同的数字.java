import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=967 lang=java
 *
 * [967] 连续差相同的数字
 */

// @lc code=start
class Solution {

    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> cur = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            cur.add(i);
        }
        for (int step = 1; step <= N - 1; step++) {
            Set<Integer> cur2 = new HashSet<>();
            for(int x : cur) {
                int d = x % 10;
                if (d - K >= 0) {
                    cur2.add(10 * x + d - K);
                }
                if (d + K <= 9) {
                    cur2.add(10 * x + d + K);
                }
            }
            cur = cur2;
        }
        if (N == 1) {
            cur.add(0);
        }
        return cur.stream().mapToInt(i -> i).toArray();
    }

}
// @lc code=end

