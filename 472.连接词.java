import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=472 lang=java
 *
 * [472] 连接词
 */

// @lc code=start
class Solution {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }
    public TrieNode root = new TrieNode();
    public void insert(String word) {
        if (word.length() == 0) return;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.isWord = true;
    }
    public boolean search(String word, int count, int index) {
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
            if (cur.isWord && search(word, count + 1, i + 1)) {
                return true;
            }
        }
        return count > 0 && cur.isWord;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        for (String word: words) {
            insert(word);
        }
        for (String word: words) {
            if (search(word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }
}
// @lc code=end

