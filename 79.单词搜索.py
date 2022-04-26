# @before-stub-for-debug-begin
from python3problem79 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=79 lang=python3
#
# [79] 单词搜索
#

# @lc code=start
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m = len(board)
        n = len(board[0])
        visited = set()
        def check(i, j, k):
            if board[i][j] != word[k]:
                return False
            if len(word) == k + 1:
                return True
            visited.add((i, j))
            result = False
            for di, dj in directions:
                newi, newj = i + di, j + dj
                if 0 <= newi <= m - 1 and 0 <= newj <= n - 1:
                    if (newi, newj) not in visited:
                        if check(newi, newj, k + 1):
                            result = True
                            break
            visited.remove((i, j))
            return result
        for i in range(0, m):
            for j in range(0, n):
                if (check(i, j, 0)):
                    return True
        return False
# @lc code=end

