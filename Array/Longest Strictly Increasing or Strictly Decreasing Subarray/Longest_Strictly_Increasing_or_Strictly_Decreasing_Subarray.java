// Problem Name: Longest Strictly Increasing or Strictly Decreasing Subarray
// Problem Link: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int inc = 1, dec = 1;
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                dec++;
                inc = 1;
            } else if (nums[i] < nums[i + 1]) {
                dec = 1;
                inc++;
            } else {
                dec = 1;
                inc = 1;
            }
            ans = Math.max(ans, Math.max(inc, dec));
        }
        return ans;
    }
}