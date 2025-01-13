// Problem Name: Minimum Length of String After Operations
// Problem Link: https://leetcode.com/problems/minimum-length-of-string-after-operations/description/

class Solution {
public:
    int minimumLength(string s) {
        unordered_map<char, int> mp;
        for (char ch : s) {
            mp[ch]++;
        }
        int ans = 0;
        for (auto it : mp) {
            if (it.second > 2) {
                if (it.second % 2 == 0)
                    ans += 2;
                else
                    ans++;
            } else {
                ans += it.second;
            }
        }
        return ans;
    }
};