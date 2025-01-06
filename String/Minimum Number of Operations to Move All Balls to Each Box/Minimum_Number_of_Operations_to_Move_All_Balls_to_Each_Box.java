// Problem Name: Minimum Number of Operations to Move All Balls to Each Box
// Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description

// Approach-1: Brute Force
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i = 0;i<n;i++) {
            if(boxes.charAt(i) == '1') {
                for(int j = 0;j<n;j++) {
                    ans[j]+=Math.abs(j-i);
                }
            }
        }
        return ans;
    }
}