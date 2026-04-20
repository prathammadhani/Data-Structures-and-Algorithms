//Problem Name: Replace Elements with Greatest Element on Right Side
//Problem Link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int n = arr.size();
        int curr = arr[n-1];
        vector<int> ans(n, -1);
        for(int i = n-2;i>=0;i--) {
            curr = max(arr[i+1], curr);
            ans[i] = curr;
        }
        return ans;
    }
};