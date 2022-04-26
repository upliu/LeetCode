# @before-stub-for-debug-begin
from python3problem605 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=605 lang=python3
#
# [605] 种花问题
#
# https://leetcode-cn.com/problems/can-place-flowers/description/
#
# algorithms
# Easy (32.15%)
# Likes:    189
# Dislikes: 0
# Total Accepted:    38.8K
# Total Submissions: 120.7K
# Testcase Example:  '[1,0,0,0,1]\n1'
#
# 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
# 
# 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n
# 朵花？能则返回True，不能则返回False。
# 
# 示例 1:
# 
# 
# 输入: flowerbed = [1,0,0,0,1], n = 1
# 输出: True
# 
# 
# 示例 2:
# 
# 
# 输入: flowerbed = [1,0,0,0,1], n = 2
# 输出: False
# 
# 
# 注意:
# 
# 
# 数组内已种好的花不会违反种植规则。
# 输入的数组长度范围为 [1, 20000]。
# n 是非负整数，且不会超过输入数组的大小。
# 
# 
#

# @lc code=start
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True
        length = len(flowerbed)
        i = 0
        while i < length:
            if flowerbed[i] == 1:
                i += 2
                continue
            if i - 1 >= 0 and flowerbed[i - 1] == 1:
                i += 1
                continue
            if i + 1 < length and flowerbed[i + 1] == 1:
                i += 3
                continue
            n -= 1
            if n == 0:
                return True
        return False

        
# @lc code=end

