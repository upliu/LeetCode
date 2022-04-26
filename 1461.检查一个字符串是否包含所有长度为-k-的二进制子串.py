#
# @lc app=leetcode.cn id=1461 lang=python3
#
# [1461] 检查一个字符串是否包含所有长度为 K 的二进制子串
#

# @lc code=start
class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        if len(s) < (1 << k) + k - 1:
            return False
        
        exists = set(s[i:i+k] for i in range(len(s) - k + 1))
        return len(exists) == (1 << k)
# @lc code=end

