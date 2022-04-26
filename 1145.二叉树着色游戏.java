/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = find(root, x);
        if (node != null) {
            int leftSize = sizeOfTree(node.left);
            int rightSize = sizeOfTree(node.right);
            int pSize = n - leftSize - rightSize - 1;
            if (leftSize * 2 > n || rightSize * 2 > n || pSize * 2 > n) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    TreeNode find(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return root;
        }
        TreeNode l = find(root.left, x);
        if (l != null) {
            return l;
        }
        return find(root.right, x);
    }

    int sizeOfTree(TreeNode n) {
        if (n == null) return 0;
        return 1 + sizeOfTree(n.left) + sizeOfTree(n.right);
    }
}
// @lc code=end

