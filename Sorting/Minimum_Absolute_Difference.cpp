// Problem: 1200. Minimum Absolute Difference
// Problem Link: https://leetcode.com/problems/minimum-absolute-difference/description/

class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(),arr.end());
        vector<vector<int>> ans;
        int min_diff = INT_MAX;
        for(int i = 0;i<n-1;i++) {
            min_diff = min(min_diff, arr[i+1]-arr[i]);
        }
        for(int i = 0;i<n-1;i++) {
            if(arr[i+1] - arr[i] == min_diff) {
                ans.push_back({arr[i],arr[i+1]});
            }
        }
        return ans;
    }
};