#
# @lc app=leetcode.cn id=1022 lang=python3
#
# [1022] 从根到叶的二进制数之和
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
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        ans = 0
        def h(root: TreeNode, sum):
            nonlocal ans
            newSum = sum * 2 + root.val
            if root.left is None and root.right is None:
                ans += newSum
                return
            if root.left:
                h(root.left, newSum)
            if root.right:
                h(root.right, newSum)
        h(root, 0)
        return ans
# @lc code=end

