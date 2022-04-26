/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
 */
import java.util.Map;
import java.util.HashMap;
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
    Map<Integer, Integer> depth = new HashMap<>();Map<Integer, TreeNode> parent = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
    }
    public void dfs(TreeNode node, TreeNode par) {
        if (node != null){
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}