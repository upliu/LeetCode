#
# @lc app=leetcode.cn id=513 lang=python3
#
# [513] 找树左下角的值
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        level = 1
        val = root.val
        def traverse(root, l):
            if root.right:
                traverse(root.right, l + 1)
            if root.left:
                traverse(root.left, l + 1)
            else:
                if l > level:
                    level, val = l, root.val
        traverse(root, 1)
        return val


                
            
# @lc code=end

