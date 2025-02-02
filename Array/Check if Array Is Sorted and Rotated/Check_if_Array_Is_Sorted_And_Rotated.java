// Problem Name: Check if Array Is Sorted and Rotated
// Problem Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/ 

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
            }
        }
        if (nums[n - 1] > nums[0])
            cnt++;
        return cnt > 1 ? false : true;
    }
}