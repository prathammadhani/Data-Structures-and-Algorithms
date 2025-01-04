// Problem Name: Maximum Product Difference Between Two Pairs
// Problem Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/

// Approach-1 : Sorting
class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        return (nums[n-1] * nums[n-2]) - (nums[0] * nums[1]);
    }
};

// Approach-2: Find Largest and Second Largest, Smallest and Second Smallest
class Solution {
public:
    int maxProductDifference(vector<int>& nums) {
        int n = nums.size();
        int mn = INT_MAX, second_mn = INT_MAX;
        int mx = INT_MIN, second_mx = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (mx < nums[i]) {
                second_mx = mx;
                mx = nums[i];
            } else if (second_mx < nums[i]) {
                second_mx = nums[i];
            }

            if (mn > nums[i]) {
                second_mn = mn;
                mn = nums[i];
            } else if (second_mn > nums[i]) {
                second_mn = nums[i];
            }
        }
        return (mx * second_mx) - (mn * second_mn);
    }
};