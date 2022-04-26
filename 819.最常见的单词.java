import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ban = Arrays.asList(banned);
        String[] words = paragraph.replaceAll("[!?',;.]", " ").toLowerCase().split(" ");
        for(String word : words) {
            if (word.isEmpty()) continue;
            if (ban.contains(word)) continue;
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        String word = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                word = entry.getKey();
            }
        }
        return word;
    }
}
// @lc code=end

