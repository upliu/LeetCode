<?php
require 'leetcode.inc.php';

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * @param String $s
     * @return String
     */
    function reverseWords($s) {
        $a = array_filter(explode(' ', $s));
        return implode(' ', array_reverse($a));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
