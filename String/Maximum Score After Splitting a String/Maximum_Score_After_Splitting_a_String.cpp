// Problem Name: Maximum Score After Splitting a String
// Problem Link: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description

class Solution {
public:
    int maxScore(string s) {
        int n = s.size();
        int ones = 0, zeros = 0;
        int ans = INT_MIN;
        for(int i = 0;i<n-1;i++){
            if(s[i] == '1') ones++;
            else zeros++;
            ans = max(ans, zeros - ones);
        }
        if(s[n-1] == '1') ones++;
        return ans + ones;
    }
};