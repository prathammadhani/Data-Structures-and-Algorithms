//Problem Name: Replace Elements with Greatest Element on Right Side
//Problem Link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int curr = arr[n-1];
        int[] ans = new int[n];
        ans[n-1] = -1;
        for(int i = n-2;i>=0;i--) {
            curr = Math.max(arr[i+1], curr);
            ans[i] = curr;
        }
        return ans;
    }
}