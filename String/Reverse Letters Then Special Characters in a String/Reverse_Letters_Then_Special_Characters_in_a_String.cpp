//Problem Name - 3823. Reverse Letters Then Special Characters in a String
//Problem Link - https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/

class Solution {
public:
    string reverseByType(string s) {
        string lower = "", special = "";
        int n = s.length();
        vector<bool> vec(n);
        for(int i = 0;i<n;i++) {
            if(islower(s[i])) {
                lower+=s[i];
                vec[i] = false; 
            } else {
                special+=s[i];
                vec[i] = true;
            }
        }
        reverse(lower.begin(),lower.end());
        reverse(special.begin(),special.end());
        string ans = "";
        int j = 0,k = 0;
        for(int i = 0;i<n;i++) {
            if(j<lower.size() && !vec[i]) {
                ans+=lower[j++];
            } else if(k<special.size() && vec[i]) {
                ans+=special[k++];
            }
        }
        return ans;
    }
};