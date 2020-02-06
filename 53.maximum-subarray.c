/*
 * @lc app=leetcode id=53 lang=c
 *
 * [53] Maximum Subarray
 */
#include <stdio.h>
#include <stdlib.h>
// @lc code=start


int maxSubArray(int* nums, int numsSize){
    if (numsSize == 0) return 0;
    int *d = (int *)calloc(numsSize, sizeof(int));
    d[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < numsSize; i++)
    {
        if (d[i - 1] > 0) {
            d[i] = d[i - 1] + nums[i];
        } else {
            d[i] = nums[i];
        }
        if (d[i] > max) {
            max = d[i];
        }
    }
    return max;
}


// @lc code=end

