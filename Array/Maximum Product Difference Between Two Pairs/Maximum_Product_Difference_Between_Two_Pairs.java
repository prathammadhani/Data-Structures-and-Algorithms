// Problem Name: Maximum Product Difference Between Two Pairs
// Problem Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/

// Approach-1: Sorting
class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-1] * nums[n-2] - nums[0] * nums[1];
    }
}

// Approach-2: Find Largest and Second Largest, Smallest and Second Smallest
class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int mn = Integer.MAX_VALUE, second_mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE, second_mx = Integer.MIN_VALUE;
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
}