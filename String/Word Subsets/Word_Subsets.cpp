// Problem Name: Word Subsets
// Problem Link: https://leetcode.com/problems/word-subsets/

class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        int n = words1.size(), m = words2.size();
        vector<int> total(26, 0);
        for (string s : words2) {
            vector<int> freq(26, 0);
            for (char ch : s) {
                freq[ch - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                total[k] = max(total[k], freq[k]);
            }
        }

        vector<string> ans;
        for (string s : words1) {
            vector<int> freq(26, 0);
            for (char ch : s) {
                freq[ch - 'a']++;
            }

            bool flag = true;
            for (int k = 0; k < 26; k++) {
                if (freq[k] < total[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans.push_back(s);
        }

        return ans;
    }
};