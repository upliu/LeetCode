/*
 * @lc app=leetcode id=152 lang=cpp
 *
 * [152] Maximum Product Subarray
 */
#include <vector>
#include <algorithm>
using namespace std;
// @lc code=start
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.empty()) return 0;
        int n = nums.size();
        int ret, largest, smallest;
        ret = largest = smallest = nums[0];
        for (int i = 1; i < n; i++)
        {
            int temp_largest = largest;
            largest = max(max(smallest * nums[i], largest * nums[i]), nums[i]);
            smallest = min(min(smallest * nums[i], temp_largest * nums[i]), nums[i]);
            ret = max(ret, largest);
        }
        return ret;
    }
};
// @lc code=end

