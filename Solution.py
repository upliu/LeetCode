from typing import *
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if not wordSet or endWord not in wordSet:
            return 0
        visited = {}
        path = []
        path.append(beginWord)
        visited[beginWord] = 1
        while path:
            cur = path.pop()
            chars = list(cur)
            step = visited[cur]
            for k in range(len(chars)):
                backup = chars[k]
                for letter in range(26):
                    chars[k] = chr(ord('a') + letter)
                    new_cur = ''.join(chars)
                    if new_cur == endWord:
                        return step + 1
                    if new_cur not in visited and new_cur in wordSet:
                        visited[new_cur] = step + 1
                        path.append(new_cur)
                chars[k] = backup
        return 0
