#
# @lc app=leetcode.cn id=208 lang=python3
#
# [208] 实现 Trie (前缀树)
#

# @lc code=start
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.childs = [None] * 26
        self.isWord = False


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        last = self
        for ch in word:
            k = ord(ch) - ord('a')
            if not last.childs[k]:
                last.childs[k] = Trie()
            last = last.childs[k]
        last.isWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        last = self
        for ch in word:
            k = ord(ch) - ord('a')
            if not last.childs[k]:
                return False
            last = last.childs[k]
        return last.isWord


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        last = self
        for ch in prefix:
            k = ord(ch) - ord('a')
            if not last.childs[k]:
                return False
            last = last.childs[k]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
# @lc code=end

