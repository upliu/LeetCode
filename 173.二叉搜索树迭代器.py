# @before-stub-for-debug-begin
from python3problem173 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=173 lang=python3
#
# [173] 二叉搜索树迭代器
#
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def pushLeft(self, root: TreeNode):
        self.stack.append(root)
        if root.left:
            self.pushLeft(root.left)

    def __init__(self, root: TreeNode):
        self.stack = []
        if root:
            self.pushLeft(root)

    def next(self) -> int:
        m = self.stack.pop()
        if m.right:
            self.pushLeft(m.right)
        return m.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
# @lc code=end

