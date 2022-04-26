<?php
require 'leetcode.inc.php';
$s = new Solution();
$ret = $s->findMin([4,5,6,7,0,1,2]);
var_dump($ret);
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findMin($nums) {
        if (count($nums) === 1) return $nums[0];
        $l = 0;
        $r = count($nums) - 1;
        if ($nums[$r] > $nums[0]) {
            return $nums[0];
        }
        while ($l <= $r) {
            $mid = (int)(($l + $r) / 2);
            if ($nums[$mid] > $nums[$mid + 1]) {
                return $nums[$mid + 1];
            }
            if ($nums[$mid - 1] > $nums[$mid]) {
                return $nums[$mid];
            }
            if ($nums[0] < $nums[$mid]) {
                $l = $mid + 1;
            } else {
                $r = $mid - 1;
            }
        }
        return $nums[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
