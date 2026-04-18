//Problem Name: Palindrome Number
//Problem Link: https://leetcode.com/problems/palindrome-number/description/

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = x;
        long reverseNum = 0;
        while (temp > 0) {
            reverseNum = reverseNum * 10 + (temp % 10);
            temp /= 10;
        }
        return reverseNum == x;
    }
}