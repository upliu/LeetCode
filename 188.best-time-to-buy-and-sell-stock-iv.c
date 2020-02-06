/*
 * @lc app=leetcode id=188 lang=c
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
#include <stdio.h>
#include <stdlib.h>
// @lc code=start

int max(int a ,int b) {
    return a > b ? a : b;
}
int maxProfit(int k, int* prices, int pricesSize){
    if (0 == pricesSize) return 0;
    int ret;
    if (k >= pricesSize / 2) {
        for (int i = 1; i < pricesSize; i++)
        {
            if (prices[i] > prices[i - 1]) {
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }
    int *sell = (int *)calloc(k + 1, sizeof(int));
    int *buy = (int *)calloc(k + 1, sizeof(int));
    memset(sell, 0, sizeof(sell));
    memset(buy, 0, sizeof(buy));
    for (int i = 0; i < pricesSize; i++)
    {
        for (int j = 1; j <= k; j++)
        {
            buy[j] = max(sell[j - 1] - prices[i], buy[j]);
            sell[j] = max(buy[j] + prices[i], sell[j]);
        }
    }
    
}


// @lc code=end

