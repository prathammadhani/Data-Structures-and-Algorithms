//Problem Name: Prerequisite Tasks
//Problem Link: https://www.geeksforgeeks.org/problems/prerequisite-tasks/

class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        int cnt = 0;
        int[] inDegree = new int[N];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<N;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<P;i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        
        for(int i = 0;i<N;i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int node = q.peek();
            cnt++;
            q.remove(node);
            for(Integer it : adj.get(node)) {
                inDegree[it]--;
                if(inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        
        if(cnt == N) return true;
        return false;
    }
}