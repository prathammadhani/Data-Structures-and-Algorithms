// Problem Name: Word Subsets
// Problem Link: https://leetcode.com/problems/word-subsets/

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length, m = words2.length;
        int[] total = new int[26];
        for (String s : words2) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                total[k] = Math.max(total[k], freq[k]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String s : words1) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            boolean flag = true;
            for (int k = 0; k < 26; k++) {
                if (freq[k] < total[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
                ans.add(s);
        }
        return ans;
    }
}