//Problem Name: Robot Return to Origin
//Problem Link: https://leetcode.com/problems/robot-return-to-origin/description/

class Solution {
public:
    bool judgeCircle(string moves) {
        int x = 0, y = 0;
        int n = moves.length();
        for(int i = 0;i<n;i++) {
            if(moves[i] == 'U') {
                x--;
            } else if(moves[i] == 'D') {
                x++;
            } else if(moves[i] == 'L') {
                y--;
            } else {
                y++;
            }
        }
        return x == 0 && y == 0;
    }
};