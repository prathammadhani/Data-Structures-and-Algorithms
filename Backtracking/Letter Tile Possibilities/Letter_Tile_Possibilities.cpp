// Problem Name: Letter Tile Possibilities
// Problem Link: https://leetcode.com/problems/letter-tile-possibilities/description/

class Solution {
public:
    int helper(vector<int> & freq) {
        int ways = 0;
        for(int i = 0;i<26;i++) {
            if(freq[i] > 0) {
                freq[i]--;
                ways+= 1 + helper(freq);
                freq[i]++;
            }
        }
        return ways;
    }
    int numTilePossibilities(string tiles) {
        int n = tiles.size();
        vector<int> freq(26, 0);
        for(int i = 0;i<n;i++) freq[tiles[i]-'A']++;
        return helper(freq);
    }
};


