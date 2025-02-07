// Problem Name: Find the Number of Distinct Colors Among the Balls
// Problem Link: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/

class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        vector<int> ans;
        unordered_map<int, int> mp1, mp2;
        for (auto& q : queries) {
            int ball = q[0];
            int color = q[1];
            if (mp1.find(ball) == mp1.end()) {
                mp2[color]++;
                mp1[ball] = color;
            } else {
                if (mp1[ball] != color) {
                    mp2[mp1[ball]]--;
                    if (mp2[mp1[ball]] == 0) {
                        mp2.erase(mp1[ball]);
                    }
                    mp1[ball] = color;
                    mp2[color]++;
                }
            }
            ans.push_back(mp2.size());
        }
        return ans;
    }
};