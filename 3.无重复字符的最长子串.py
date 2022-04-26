# @before-stub-for-debug-begin
from python3problem3 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, ans, n = -1, 0, len(s)
        uniq = set()
        for r in range(n):
            while s[r] in uniq:
                if l >= 0: 
                    uniq.remove(s[l])
                l += 1
            uniq.add(s[r])
            ans = max(ans, len(uniq))
        return ans
# @lc code=end

