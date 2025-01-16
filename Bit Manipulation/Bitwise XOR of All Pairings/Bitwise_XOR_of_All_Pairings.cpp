// Problem Name: Bitwise XOR of All Pairings
// Problem Link: https://leetcode.com/problems/bitwise-xor-of-all-pairings/

// Approach 1 - HashMap
class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        unordered_map<int, long> mp;
        for (int i = 0; i < n; i++) {
            mp[nums1[i]] += m;
        }
        for (int i = 0; i < m; i++) {
            mp[nums2[i]] += n;
        }
        int ans = 0;
        for (auto& it : mp) {
            if (it.second % 2 != 0) {
                ans ^= it.first;
            }
        }
        return ans;
    }
};

// Approach 2 - Space Optimized
class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        int m = nums2.size();
        int ans = 0;
        if (m % 2 != 0) {
            for (int i = 0; i < n; i++) {
                ans ^= nums1[i];
            }
        }
        if (n % 2 != 0) {
            for (int i = 0; i < m; i++) {
                ans ^= nums2[i];
            }
        }
        return ans;
    }
};

