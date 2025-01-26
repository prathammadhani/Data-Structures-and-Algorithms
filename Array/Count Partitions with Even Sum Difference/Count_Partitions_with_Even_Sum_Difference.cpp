// Problem Name: Count Partitions with Even Sum Difference
// Problem Link: https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/ 

class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int sum2 = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            sum2 += nums[i];
            sum -= nums[i];
            if ((sum - sum2) % 2 == 0)
                ans++;
        }
        return ans;
    }
};