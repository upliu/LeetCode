/*
 * @lc app=leetcode.cn id=646 lang=javascript
 *
 * [646] 最长数对链
 */

// @lc code=start
/**
 * @param {number[][]} pairs
 * @return {number}
 */
var findLongestChain = function(pairs) {
    pairs.sort((a, b) => a[0] - b[0]);
    const N = pairs.length;
    let dp = [];
    dp[0] = 1;
    let ans = 0;
    for (let i = 0; i < N; i++) {
        let max = 0;
        for (let j = 0; j < i; j++) {
            if (pairs[i][0] > pairs[j][1]) {
                max = Math.max(max, dp[j]);
            }
        }
        dp[i] = max + 1;
        ans = Math.max(ans, dp[i]);
    }
    return ans;
};
// @lc code=end

let ret = findLongestChain([[1,2], [2,3], [3,4]])
console.dir(ret)