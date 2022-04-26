/*
 * @lc app=leetcode id=337 lang=c
 *
 * [337] House Robber III
 */
#include <stdio.h>
#include <stdlib.h>
struct TrieNode {
    int val;
    struct TrieNode *left;
    struct TrieNode *right;
};
// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TrieNode {
 *     int val;
 *     struct TrieNode *left;
 *     struct TrieNode *right;
 * };
 */

int max(int a ,int b) {
    return a > b ? a : b;
}

int* _rob(struct TrieNode* root){
    int *ret = (int *)calloc(2, sizeof(int));
    if (NULL == root) return ret;
    int *left = _rob(root->left);
    int *right = _rob(root->right);
    ret[0] = max(left[0], left[1]) + max(right[0], right[1]);
    ret[1] = root->val + left[0] + right[0];
    return ret;
}

int rob(struct TrieNode* root){
    if (NULL == root) return 0;
    int *ret = _rob(root);
    return max(ret[0], ret[1]);
}



// @lc code=end

