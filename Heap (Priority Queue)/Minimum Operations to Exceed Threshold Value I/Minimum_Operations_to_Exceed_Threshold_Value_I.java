// Problem Name: Minimum Operations to Exceed Threshold Value I
// Problem Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/

// Approach-1: Sorting
class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k)
                break;
            ans++;
        }
        return ans;
    }
}


// Approach-2: Priority Queue
class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }
        while (pq.peek() < k) {
            Integer x = pq.poll();
            ans++;
        }
        return ans;
    }
}