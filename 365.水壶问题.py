#
# @lc app=leetcode.cn id=365 lang=python3
#
# [365] 水壶问题
#

# @lc code=start
class Solution:
    def canMeasureWater(self, jug1Capacity: int, jug2Capacity: int, targetCapacity: int) -> bool:
        stack = [(0, 0)]
        visited = set()
        while stack:
            (remain_x, remain_y) = stack.pop()
            if remain_x == targetCapacity or remain_y == targetCapacity or remain_x + remain_y == targetCapacity:
                return True
            if (remain_x, remain_y) in visited:
                continue
            visited.add((remain_x, remain_y))
            stack.append((jug1Capacity, remain_y))
            stack.append((remain_x, jug2Capacity))
            stack.append((0, remain_y))
            stack.append((remain_x, 0))
            stack.append((remain_x - min(remain_x, jug2Capacity - remain_y), remain_y + min(remain_x, jug2Capacity - remain_y)))
            stack.append((remain_x + min(remain_y, jug1Capacity - remain_x), remain_y - min(remain_y, jug1Capacity - remain_x)))
        return False
# @lc code=end

