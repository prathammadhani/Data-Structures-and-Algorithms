//Problem Name - 3823. Reverse Letters Then Special Characters in a String
//Problem Link - https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/description/

class Solution {
    public String reverseByType(String s) {
        String lower = "", special = "";
        int n = s.length();
        boolean vec[] = new boolean[n];
        for(int i = 0;i<n;i++) {
            if(Character.isLowerCase(s.charAt(i))) {
                lower+=s.charAt(i);
                vec[i] = false; 
            } else {
                special+=s.charAt(i);
                vec[i] = true;
            }
        }
        StringBuilder reverseLower = new StringBuilder(lower);
        StringBuilder reverseSpecial = new StringBuilder(special);
        reverseLower.reverse();
        reverseSpecial.reverse();
        lower = reverseLower.toString();
        special = reverseSpecial.toString();
        String ans = "";
        int j = 0,k = 0;
        for(int i = 0;i<n;i++) {
            if(j<lower.length() && !vec[i]) {
                ans+=lower.charAt(j++);
            } else if(k<special.length() && vec[i]) {
                ans+=special.charAt(k++);
            }
        }
        return ans;
    }
}