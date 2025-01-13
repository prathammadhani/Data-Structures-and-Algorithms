// Problem Name: Minimum Length of String After Operations
// Problem Link: https://leetcode.com/problems/minimum-length-of-string-after-operations/description/

class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), 1);
            } else {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            if (e.getValue() > 2) {
                if (e.getValue() % 2 == 0) {
                    ans += 2;
                } else {
                    ans++;
                }
            } else {
                ans += e.getValue();
            }
        }
        return ans;
    }
}