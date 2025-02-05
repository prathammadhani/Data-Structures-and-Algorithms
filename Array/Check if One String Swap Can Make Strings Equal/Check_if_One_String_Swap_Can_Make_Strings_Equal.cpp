// Problem Name: Check if One String Swap Can Make Strings Equal
// Problem Link: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/

// Approach 1: Check occurences + Check difference 
class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if (s1.length() != s2.length())
            return false;
        else if (s1 == s2)
            return true;
        int n = s1.length();
        unordered_map<char, int> mp;
        for (int i = 0; i < n; i++)
            mp[s1[i]]++;
        for (int i = 0; i < n; i++) {
            if (mp.find(s2[i]) == mp.end())
                return false;
            else {
                mp[s2[i]]--;
                if (mp[s2[i]] == 0)
                    mp.erase(s2[i]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s1[i] != s2[i]) {
                cnt++;
            }
        }
        return cnt == 2;
    }
};

// Approach 2: Only Check Difference
class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        if (s1.length() != s2.length())
            return false;
        else if (s1 == s2)
            return true;
        int n = s1.length();
        int cnt = 0, firstDiff = 0, secondDiff = 0;
        for (int i = 0; i < n; i++) {
            if (s1[i] != s2[i]) {
                cnt++;
                if(cnt == 1) {
                    firstDiff = i;
                } else {
                    secondDiff = i;
                }
            }
            if(cnt > 2) return false;
        }
        return s1[firstDiff] == s2[secondDiff] && s1[secondDiff] == s2[firstDiff];
    }
};