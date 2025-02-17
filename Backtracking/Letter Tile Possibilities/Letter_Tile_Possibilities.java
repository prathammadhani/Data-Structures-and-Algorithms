// Problem Name: Letter Tile Possibilities
// Problem Link: https://leetcode.com/problems/letter-tile-possibilities/description/

class Solution {
    public int helper(int[] freq) {
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
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        int[] freq = new int[26];
        for(int i = 0;i<n;i++) freq[tiles.charAt(i) - 'A']++;
        return helper(freq);
    }
}