//Problem Name: Valid Anagram
//Problem Link: https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m)
            return false;
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            if (mp.containsKey(ch) && mp.get(ch) > 0) {
                mp.put(ch, mp.getOrDefault(ch, 0) - 1);
                if (mp.get(ch) == 0)
                    mp.remove(ch);
            } else
                return false;
        }
        return true;
    }
}