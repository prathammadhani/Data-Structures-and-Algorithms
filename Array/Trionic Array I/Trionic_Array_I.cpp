//Problem Name: 3637. Trionic Array I
//Problem Link: https://leetcode.com/problems/trionic-array-i/description/

class Solution {
public:
    bool isTrionic(vector<int>& nums) {
        int n = nums.size();
        if(nums[0]>nums[1]) return false;
        int i = 1;
        bool inc1 = false, dec1 = false, inc2 = false;
        while(i<n && nums[i-1]<nums[i]) {
            if(!inc1) inc1 = true;
            i++;
        }
        while(i<n && nums[i-1]>nums[i]) {
            if(!dec1) dec1 = true;
            i++;
        }
        while(i<n && nums[i-1]<nums[i]) {
            if(!inc2) inc2 = true;
            i++;
        }
        return (inc1 && dec1 && inc2 && i == n) ? true : false;
    }
};