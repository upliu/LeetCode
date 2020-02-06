/*
 * @lc app=leetcode id=213 lang=c
 *
 * [213] House Robber II
 */
#include <stdio.h>
#include <stdlib.h>
// @lc code=start

int _rob(int* nums, int from, int end){
    if (from > end) return 0;
    if (from == end) return nums[from];
    int *d = (int *)calloc(end - from + 1, sizeof(int));
    d[0] = nums[from];
    d[1] = nums[from + 1] > nums[from] ? nums[from + 1] : nums[from];
    for (int i = 2; i < end - from + 1; i++)
    {
        if (d[i-2] + nums[i + from] > d[i-1]) {
            d[i] = d[i-2] + nums[i + from];
        } else {
            d[i] = d[i-1]; 
        }
    }
    return d[end - from];
}

int rob(int* nums, int numsSize){
    if (numsSize == 0) return 0;
    if (numsSize == 1) return nums[0];
    int ret1 = _rob(nums, 0, numsSize - 2);
    int ret2 = _rob(nums, 1, numsSize - 1);
    return ret1 > ret2 ? ret1 : ret2;
}


// @lc code=end

