// Problem Name: LC - 494. Target Sum
// Problem Link: https://leetcode.com/problems/target-sum/description/

// Recursion
class Solution {
public:
    int solve(int ind, vector<int>& nums, int target, int sum) {
        if (ind < 0 && sum == target)
            return 1;
        if (ind < 0)
            return 0;
        int pos = solve(ind - 1, nums, target, sum + nums[ind]);
        int neg = solve(ind - 1, nums, target, sum + (-nums[ind]));
        return pos + neg;
    }
    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        return solve(n - 1, nums, target, 0);
    }
};

// Recursion + Memoization (Top-Down)
class Solution {
public:
    int solve(int ind, vector<int>& nums, int target, int sum,
              vector<unordered_map<int, int>>& dp) {
        if (ind < 0 && sum == target)
            return 1;
        if (ind < 0)
            return 0;
        if (dp[ind].count(sum))
            return dp[ind][sum];
        int pos = solve(ind - 1, nums, target, sum + nums[ind], dp);
        int neg = solve(ind - 1, nums, target, sum + (-nums[ind]), dp);
        return dp[ind][sum] = pos + neg;
    }
    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        vector<unordered_map<int, int>> dp(n);
        return solve(n - 1, nums, target, 0, dp);
    }
};