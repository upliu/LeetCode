<?php
require 'leetcode.inc.php';
$s = new Solution();
$s->findPeakElement([3,2,1]);
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findPeakElement($nums) {
        $len = count($nums);
        $l = 0;
        $r = $len - 1;
        while ($l <= $r) {
            $mid = (int)(($l + $r) / 2);
            if (($mid - 1 < 0 || $nums[$mid - 1] < $nums[$mid]) && ($mid + 1 > $len - 1 || $nums[$mid] > $nums[$mid + 1])) {
                return $mid;
            }
            if ($mid - 1 >= 0 && $nums[$mid - 1] > $nums[$mid]) {
                $r = $mid - 1;
            } else {
                $l = $mid + 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
