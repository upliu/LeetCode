/*
 * @lc app=leetcode.cn id=321 lang=cpp
 *
 * [321] 拼接最大数
 */
#include<vector>
#include<iostream>
using namespace std;
// @lc code=start
class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size(), n = nums2.size();
        vector<int> res(k, 0);
        for (int l = max(0, k - n); l < min(k, m); l++)
        {
            vector<int> s1 = maxSequence(nums1, l);
            vector<int> s2 = maxSequence(nums2, k - l);
            vector<int> temp = merge(s1, s2);
            if (lexicographical_compare(temp.begin(), temp.end(), res.begin(), res.end())) {
                res = temp;
            }
        }
        return res;
    }

    // 合并
    vector<int> merge(vector<int>& s1, vector<int>& s2) {
        int m = s1.size(), n = s2.size();
        vector<int> res;
        int i = m;
        int j = n;
        while (i > 0 || j > 0)
        {
            if (i == 0) {
                while(j > 0) {
                    res.push_back(s2[--j]);
                }
            } else if (j == 0) {
                while(i > 0) {
                    res.push_back(s1[--i]);
                }
            } else {
                if (s1[i] > s2[j]) {
                    res.push_back(s1[--i]);
                } else {
                    res.push_back(s2[--j]);
                }
            }
        }
        
        res.resize(m + n);
        return res;
    }

    // 取出最大的k个数
    vector<int> maxSequence(vector<int>& nums, int k) {
        int n = nums.size();
        if (n <= k) return nums;
        int pop = n - k;
        vector<int> res;
        for (int i = 0; i < n; i++)
        {
            while (!res.empty() && nums[i] > res.back() && pop-- > 0)
            {
                res.pop_back();
            }
            res.push_back(nums[i]);
        }
        res.resize(k);
        return res;
    }
};
// @lc code=end

vector<int> test(vector<int>& v) {
    return v;
}

int main (int argc, char *argv[]) {
    vector<int> nums1 = vector<int>(4);
    nums1.push_back(3);
    nums1.push_back(4);
    nums1.push_back(6);
    nums1.push_back(5);
    vector<int> nums2 = vector<int>(6);
    nums2.push_back(9);
    nums2.push_back(1);
    nums2.push_back(2);
    nums2.push_back(5);
    nums2.push_back(8);
    nums2.push_back(3);
    Solution s;
    vector<int> ret = s.maxNumber(nums1, nums2, 5);
    auto it = ret.begin();
    while (it != ret.end()) {
        cout<<*it<<',';
        it++;
    }
    cout<<endl;
    return 0;
}