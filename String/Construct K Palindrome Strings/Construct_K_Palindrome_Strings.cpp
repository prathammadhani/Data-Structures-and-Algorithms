// Problem Name: Construct K Palindrome Strings
// Problem Link: https://leetcode.com/problems/construct-k-palindrome-strings/description

class Solution {
public:
    bool canConstruct(string s, int k) {
        int n = s.length();
        if (n < k) return false;
        else if(n == k) return true;
        int ans = 0;
        unordered_map<char,int> mp;
        for(char ch : s) mp[ch]++;
        for(auto &it : mp) {
            if(it.second%2!=0) ans++;
        }
        return ans<=k;
    }
};