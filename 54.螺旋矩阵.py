#
# @lc app=leetcode.cn id=54 lang=python3
#
# [54] 螺旋矩阵
#

# @lc code=start
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m, n = len(matrix), len(matrix[0])
        x0, y0 = 0, 0
        x1, y1 = 0, 0
        x2, y2 = m - 1, n - 1
        direction = 0
        ans = []
        while x1 <= x0 <= x2 and y1 <= y0 <= y2:
            ans.append(matrix[x0][y0])
            if direction == 0:
                while y0
                new_y0 += 1
            elif direction == 1:
                new_x0 += 1
            elif direction == 2:
                new_y0 -= 1
            else:
                new_x0 -= 1
            
# @lc code=end

