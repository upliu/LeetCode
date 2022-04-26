#
# @lc app=leetcode.cn id=1362 lang=python3
#
# [1362] 最接近的因数
#

# @lc code=start
class Solution:
    def closestDivisors(self, num: int) -> List[int]:
        import math
        def h(num):
            mid = int(math.sqrt(num))
            for i in range(mid, 0, -1):
                if i * (num // i) == num:
                    return [i, num // i]
        a = h(num + 1)
        b = h(num + 2)
        if abs(a[0] - a[1]) > abs(b[0] - b[1]):
            return b
        else:
            return a


# @lc code=end

