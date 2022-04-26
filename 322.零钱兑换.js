/*
 * @lc app=leetcode.cn id=322 lang=javascript
 *
 * [322] 零钱兑换
 */

// @lc code=start
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    return _coinChange(coins, amount, {});
};
var _coinChange = function(coins, amount, coinChangeMap) {
    if (amount == 0) return 0;
    if (amount < 0) return NaN;
    if (coinChangeMap[amount]) return coinChangeMap[amount];
    var res = -1;
    for (let index = 0; index < coins.length; index++) {
        const element = coins[index];
        if (amount >= element) {
            var t = 1 + _coinChange(coins, amount - element, coinChangeMap);
            if (t > 0 && (res == -1 || t < res)) {
                res = t;
            }
        }
    }
    coinChangeMap[amount] = res;
    return res;
};
// @lc code=end

var ret = coinChange([2], 3);
console.log(ret);