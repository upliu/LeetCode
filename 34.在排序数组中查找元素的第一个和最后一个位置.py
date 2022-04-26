# @before-stub-for-debug-begin
from python3problem34 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=34 lang=python3
#
# [34] 在排序数组中查找元素的第一个和最后一个位置
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        left, right = 0, n - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target > nums[mid]:
                left = mid + 1
            elif target < nums[mid]:
                right = mid - 1
            else:
                left = right = mid
                while left - 1 >= 0 and nums[left - 1] == target:
                    left -= 1
                while right + 1 <= n - 1 and nums[right + 1] == target:
                    right += 1
                return [left, right]
        return [-1, -1]
# @lc code=end

