//Problem Name: Prerequisite Tasks
//Problem Link: https://www.geeksforgeeks.org/problems/prerequisite-tasks/

class Solution {
  public:
    bool isPossible(int N, int P, vector<pair<int, int> >& prerequisites) {
        int cnt = 0;
        vector<int> indegree(N, 0);
        queue<int> q;
        unordered_map<int, vector<int>> adj;
        for(auto it : prerequisites) {
            adj[it.first].push_back(it.second);
            indegree[it.second]++;
        }
        
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }
        
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            cnt++;
            for(auto it : adj[node]) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.push(it);
                }
            }
        }
        
        if(cnt ==  N) return true;
        return false;
    }
};