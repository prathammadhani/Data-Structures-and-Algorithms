// Problem Name: Bitwise XOR of All Pairings
// Problem Link: https://leetcode.com/problems/bitwise-xor-of-all-pairings/

// Approach 1 - HashMap
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0;i<n;i++) {
            mp.put(nums1[i], mp.getOrDefault(nums1[i], 0) + m);
        }
        for(int j = 0;j<m;j++) {
            mp.put(nums2[j], mp.getOrDefault(nums2[j], 0) + n);
        }
        for(Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() % 2 == 1) {
                ans^=e.getKey();
            }
        }
        return ans;
    }
}

// Approach 2 - Space Optimized
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        if (m % 2 == 1) {
            for (int i = 0; i < n; i++) {
                ans ^= nums1[i];
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < m; i++) {
                ans ^= nums2[i];
            }
        }
        return ans;
    }
}