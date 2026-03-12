//Problem Name: Minimum Pair Removal to Sort Array I
//Problem Link: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/description/ 

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }

        int ans = 0;
        boolean flag = true;
        for(int i = 0;i<n-1;i++) {
            if(temp.get(i)>temp.get(i+1)) {
                flag = false;
                break;
            }
        }
        if(flag) return 0;

        while(temp.size()>1) {
            int ind1 = 0;
            int minSum = Integer.MAX_VALUE;

            for(int i = 0;i<temp.size()-1;i++) {
                if(temp.get(i) + temp.get(i+1) < minSum) {
                    ind1 = i;
                    minSum = temp.get(i) + temp.get(i+1);
                }
            }

            temp.set(ind1, temp.get(ind1) + temp.get(ind1+1));
            temp.remove(ind1+1);

            ans++;

            boolean sorted = true;
            for(int i = 0;i<temp.size()-1;i++) {
                if(temp.get(i)>temp.get(i+1)) {
                    sorted = false;
                    break;
                }
            }
            if(sorted) break;
        }
        return ans;
    }
}