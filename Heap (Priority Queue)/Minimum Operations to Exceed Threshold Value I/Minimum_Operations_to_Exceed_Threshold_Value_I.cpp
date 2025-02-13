// Problem Name: Minimum Operations to Exceed Threshold Value I
// Problem Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

// Approach-1: Sorting
class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int n = nums.size(), ans = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k)
                break;
            ans++;
        }
        return ans;
    }
};

// Approach-2: Priority Queue
class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long, vector<long>, greater<long>> pq(nums.begin(),
                                                                nums.end());
        int ans = 0;
        while (pq.top() < k) {
            long x = pq.top();
            pq.pop();
            ans++;
        }
        return ans;
    }
};