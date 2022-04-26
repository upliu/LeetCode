<?php
require 'leetcode.inc.php';
$ret = (new Solution())->removeComments(["a/*comment", "line", "more_comment*/b"]);
var_dump($ret);
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * @param String[] $source
     * @return String[]
     */
    function removeComments($source) {
        $inBlock = false;
        foreach ($source as $k => $line) {
            $len = strlen($line);
            $i = 0;
            if (!$inBlock) $newline = [];
            while ($i <= $len - 1) {
                if (!$inBlock && $i + 1 < $len && $line[$i] === '/' && $line[$i + 1] === '*') {
                    $inBlock = true;
                    $i++;
                } else if ($inBlock && $i + 1 < $len && $line[$i] === '*' && $line[$i + 1] === '/') {
                    $inBlock = false;
                    $i++;
                } else if (!$inBlock && $i + 1 < $len && $line[$i] === '/' && $line[$i + 1] === '/') {
                    break;
                } else if (!$inBlock) {
                    $newline[] = $line[$i];
                }
                $i++;
            }
            if (!$inBlock && count($newline) > 0) {
                $ans[] = implode('', $newline);
            }
        }
        return $ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
