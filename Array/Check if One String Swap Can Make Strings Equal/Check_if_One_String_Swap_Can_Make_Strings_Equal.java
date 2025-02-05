// Problem Name: Check if One String Swap Can Make Strings Equal
// Problem Link: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/

// Approach 1: Check occurences + Check difference 
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        else if(s1.equals(s2)) return true;
        int n = s1.length();
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        for(int i = 0;i<n;i++) {
            mp.put(s1.charAt(i), mp.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int i = 0;i<n;i++) {
            if(mp.containsKey(s2.charAt(i))) {
                mp.put(s2.charAt(i), mp.get(s2.charAt(i)) - 1);
                if(mp.get(s2.charAt(i)) == 0) mp.remove(s2.charAt(i));
            } else return false;
        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if(cnt > 2) return false;
        }
        return cnt == 2;
    }
}

// Approach 2: Only Check Difference
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        else if(s1.equals(s2)) return true;
        int n = s1.length();
        int cnt = 0, firstDiff = 0, secondDiff = 0;
        for(int i = 0;i<n;i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if(cnt == 1) {
                    firstDiff = i;
                } else {
                    secondDiff = i;
                }
            }
            if(cnt > 2) return false;
        }
        return cnt == 2;
    }
}