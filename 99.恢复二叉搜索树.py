# @before-stub-for-debug-begin
from python3problem99 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=99 lang=python3
#
# [99] 恢复二叉搜索树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        if root.left and root.left.val > root.val:
            root.left.val, root.val = root.val, root.left.val
            return
        if root.right and root.right.val < root.val:
            root.right.val, root.val = root.val, root.right.val
            return
        self.recoverTree(root.left)
        self.recoverTree(root.right)
# @lc code=end

