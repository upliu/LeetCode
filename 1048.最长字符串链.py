#
# @lc app=leetcode.cn id=1048 lang=python3
#
# [1048] 最长字符串链
#
# https://leetcode-cn.com/problems/longest-string-chain/description/
#
# algorithms
# Medium (43.40%)
# Likes:    81
# Dislikes: 0
# Total Accepted:    5.7K
# Total Submissions: 13.2K
# Testcase Example:  '["a","b","ba","bca","bda","bdca"]'
#
# 给出一个单词列表，其中每个单词都由小写英文字母组成。
# 
# 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是
# "abac" 的前身。
# 
# 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2
# 的前身，word_2 是 word_3 的前身，依此类推。
# 
# 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
# 
# 
# 示例：
# 
# 输入：["a","b","ba","bca","bda","bdca"]
# 输出：4
# 解释：最长单词链之一为 "a","ba","bda","bdca"。
# 
# 
# 
# 
# 提示：
# 
# 
# 1 <= words.length <= 1000
# 1 <= words[i].length <= 16
# words[i] 仅由小写英文字母组成。
# 
# 
# 
# 
#

# @lc code=start
class Solution:
    def longestStrChain(self, words: List[str]) -> int:
# @lc code=end

