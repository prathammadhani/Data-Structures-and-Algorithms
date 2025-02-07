// Problem Name: Find the Number of Distinct Colors Among the Balls
// Problem Link: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int k = 0;
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        for(int[] q : queries) {
            int ball = q[0];
            int color = q[1];
            if(!mp1.containsKey(ball)) {
                mp1.put(ball, color);
                mp2.put(color, mp2.getOrDefault(color, 0) + 1);
            } else {
                if(mp1.get(ball) != color) {
                    int prevColor = mp1.get(ball);
                    mp2.put(prevColor, mp2.get(prevColor) - 1);
                    if (mp2.get(prevColor) == 0) {
                        mp2.remove(prevColor);
                    }
                    mp1.put(ball, color);
                    mp2.put(color, mp2.getOrDefault(color, 0) + 1);
                }
            }
            ans[k++] = mp2.size();
        }
        return ans;
    }
}