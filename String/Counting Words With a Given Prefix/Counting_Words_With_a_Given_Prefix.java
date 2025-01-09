// Problem Name: Counting Words With a Given Prefix
// Problem Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/ 

class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                ans++;
            }
        }
        return ans;
    }
}