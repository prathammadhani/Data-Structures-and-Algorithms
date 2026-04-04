//Problem Name: Valid Anagram
//Problem Link: https://leetcode.com/problems/valid-anagram/

class Solution {
public:
    bool isAnagram(string s, string t) {
        int n = s.length();
        int m = t.length();
        if (n != m)
            return false;
        unordered_map<char, int> mp;
        for (int i = 0; i < n; i++)
            mp[s[i]]++;
        for (int i = 0; i < m; i++) {
            if (mp.find(t[i]) != mp.end() && mp[t[i]] > 0) {
                mp[t[i]]--;
                if (mp[t[i]] == 0)
                    mp.erase(t[i]);
            } else
                return false;
        }
        return true;
    }
};