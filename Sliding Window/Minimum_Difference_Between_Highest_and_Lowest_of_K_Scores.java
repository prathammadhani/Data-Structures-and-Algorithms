// Problem: 1984. Minimum Difference Between Highest and Lowest of K Scores
// Problem Link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return 0;
        Arrays.sort(nums);
        int left = 0, right = 0;
        int ans = Integer.MAX_VALUE;
        while(right < n){
            if(right - left + 1 < k) right++;
            else if(right - left + 1 == k) {
                ans = Math.min(ans, nums[right] - nums[left]);
                left++;
            }
        }
        return ans;
    }
}