//Problem Name: Two Furthest Houses With Different Colors
//Problem Link: https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/

class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int n = colors.size();
        int mx = INT_MIN;
        for(int i = 0;i<n;i++) {
            for(int j = i+1;j<n;j++) {
                if(colors[i] != colors[j]) {
                    mx = max(mx, j-i);
                }
            }
        }
        return mx;
    }
};