// Problem: 1984. Minimum Difference Between Highest and Lowest of K Scores
// Problem Link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/

class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        int n = nums.size();
        if(n == 1) return 0;
        sort(nums.begin(),nums.end());
        int left  = 0, right = 0;
        int ans = INT_MAX;
        while(right < n) {
            if(right - left + 1 < k) right++;
            else if(right - left + 1 == k) {
                ans = min(ans, nums[right]-nums[left]);
                left++;
            }
        }
        return ans;
    }
};