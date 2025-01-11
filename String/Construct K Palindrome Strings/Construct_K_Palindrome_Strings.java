// Problem Name: Construct K Palindrome Strings
// Problem Link: https://leetcode.com/problems/construct-k-palindrome-strings/description

class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        else if(n == k) return true;
        int ans = 0;
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        for(int i =  0;i<n;i++) {
            if(mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
            } else {
                mp.put(s.charAt(i), 1);
            }
        }
        for(Map.Entry<Character, Integer> e : mp.entrySet()) {
            if(e.getValue()%2!=0) ans++;
        }
        return ans<=k;
    }
}