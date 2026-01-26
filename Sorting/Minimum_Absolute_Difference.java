// Problem Name: 1200. Minimum Absolute Difference
// Problem Link: https://leetcode.com/problems/minimum-absolute-difference/description/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i+1] - arr[i] == minDiff) {
                // Arrays.asList is a concise way to create a inner list
               ans.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return ans;
    }
}