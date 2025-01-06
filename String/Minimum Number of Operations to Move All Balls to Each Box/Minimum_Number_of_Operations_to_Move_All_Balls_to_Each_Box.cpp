// Problem Name: Minimum Number of Operations to Move All Balls to Each Box
// Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description

// Approach-1: Brute Force
class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n = boxes.size();
        vector<int> ans(n,0);
        for(int i = 0;i<n;i++) {
            if(boxes[i] == '1') {
                for(int j = 0;j<n;j++) {
                    ans[j]+=abs(j-i);
                }
            }
        }
        return ans;
    }
};