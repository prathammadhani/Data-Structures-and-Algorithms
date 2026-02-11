//Problem Name: Longest Balanced Subarray I
//Problem Link: https://leetcode.com/problems/longest-balanced-subarray-i/description/

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0;i<n;i++) {
            HashMap<Integer,Integer> evenMap = new HashMap<>();
            HashMap<Integer, Integer> oddMap = new HashMap<>();
            for(int j = i;j<n;j++) {
                if(nums[j] % 2 == 0) {
                    evenMap.put(nums[j], evenMap.getOrDefault(nums[j], 0) + 1);
                } else {
                    oddMap.put(nums[j], oddMap.getOrDefault(nums[j], 0) + 1);
                }
                if(evenMap.size() == oddMap.size()) ans = Math.max(ans, j-i+1); 
            }
        }
        return ans;
    }
}