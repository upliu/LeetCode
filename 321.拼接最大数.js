/*
 * @lc app=leetcode.cn id=321 lang=javascript
 *
 * [321] 拼接最大数
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number[]}
 */
var maxNumber = function(nums1, nums2, k) {
    var m = nums1.length, n = nums2.length, res = [];
    for (l = Math.max(0, k - n); l <= Math.min(k, m); l++) {
        var s1 = maxSequence(nums1, l)
        var s2 = maxSequence(nums2, k - l)
        var tmp = merge(s1, s2);
        if (tmp.join() > res.join()) {
            res = tmp;
        }
    }
    return res;
};

var merge = function(nums1, nums2) {
    var m = nums1.length, n = nums2.length;
    var i = 0;
    var j = 0;
    var res = [];
    while(i < m || j < n) {
        if (i == m) {
            while(j < n) {
                res.push(nums2[j++]);
            }
        } else if (j == n) {
            while(i < m) {
                res.push(nums1[i++]);
            }
        } else {
            if (nums1.slice(i).join() > nums2.slice(j).join()) {
                res.push(nums1[i++]);
            } else {
                res.push(nums2[j++]);
            }
        }
    }
    return res;
};

var maxSequence = function(nums, k) {
    var n = nums.length;
    if (n <= k) {
        return nums;
    }
    var pop = n - k;
    var res = [];
    for (i = 0; i < n; i++) {
        while(res.length > 0 && nums[i] > res[res.length - 1] && pop-- > 0) {
            res.pop();
        }
        res.push(nums[i]);
    }
    res = res.slice(0, k);
    return res;
};
// @lc code=end

console.log(maxNumber([6,7], [6,0,4], 5));