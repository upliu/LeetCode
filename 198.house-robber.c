/*
 * @lc app=leetcode id=198 lang=c
 *
 * [198] House Robber
 */
#include <stdio.h>
#include <stdlib.h>
// @lc code=start


int rob(int* nums, int numsSize){
    if (numsSize == 0) return 0;
    if (numsSize == 1) return nums[0];
    int *d = (int *)calloc(numsSize, sizeof(int));
    d[0] = nums[0];
    d[1] = nums[1] > nums[0] ? nums[1] : nums[0];
    for (int i = 2; i < numsSize; i++)
    {
        if (d[i-2] + nums[i] > d[i-1]) {
            d[i] = d[i-2] + nums[i];
        } else {
            d[i] = d[i-1]; 
        }
    }
    return d[numsSize - 1];
}


// @lc code=end

