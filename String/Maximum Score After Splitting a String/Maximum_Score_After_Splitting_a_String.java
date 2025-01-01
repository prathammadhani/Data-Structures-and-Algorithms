// Problem Name: Maximum Score After Splitting a String
// Problem Link: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ones = 0, zeros = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<n-1;i++) {
            if(s.charAt(i) == '1') ones++;
            else zeros++;
            ans = Math.max(ans, zeros - ones);
        }
        if(s.charAt(n-1) == '1') ones++;
        return ans + ones;
    }
}