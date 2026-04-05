//Problem Name: Robot Return to Origin
//Problem Link: https://leetcode.com/problems/robot-return-to-origin/description/

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        int n = moves.length();
        for(int i = 0;i<n;i++) {
            if(moves.charAt(i) == 'U') {
                x--;
            } else if(moves.charAt(i) == 'D') {
                x++;
            } else if(moves.charAt(i) == 'L') {
                y--;
            } else {
                y++;
            }
        }
        return x == 0 && y == 0;
    }
}