//Problem Name: Minimum Pair Removal to Sort Array I
//Problem Link: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/description/ 

class Solution {
public:
    int minimumPairRemoval(vector<int>& nums) {
        int n = nums.size();
        vector<int> temp = nums;
        int ans = 0;
        bool flag = true;
        for(int i = 0;i<n-1;i++) {
            if(temp[i]>temp[i+1]) {
                flag = false;
                break;
            }
        }
        if(flag) return 0;
        while(temp.size()>1) {
            int ind1 = -1, ind2 = -1;
            int minSum = INT_MAX;
            for(int i = 0;i<temp.size()-1;i++) {
                if(temp[i]+temp[i+1]<minSum) {
                    ind1 = i;
                    ind2 = i+1;
                    minSum = temp[i]+temp[i+1];
                }
            }
            int i = 0;
            while(i<ind1) i++;
            temp[ind1] = temp[ind1]+temp[ind2];
            for(i = ind2;i<temp.size()-1;i++) {
                temp[i] = temp[i+1];
            }
            temp.resize(temp.size()-1);
            bool flag = true;
            for(i = 0;i<temp.size()-1;i++) {
                if(temp[i]>temp[i+1]) {
                    flag = false;
                }
            }
            ans++;
            if(flag) break;
        }
        return ans;
    }
};