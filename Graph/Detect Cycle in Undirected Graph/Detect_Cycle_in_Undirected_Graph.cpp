// Problem Name: Detect Cycle in Undirected Graph
// Problem Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

// BFS Approach
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    bool bfs(int src, unordered_map<int,vector<int>>& adjList, vector<int>& vis) {
        queue<pair<int,int>> q;
        q.push({src,-1});
        vis[src] = 1;
        while (!q.empty()) {
            int node = q.front().first;
            int parent = q.front().second;
            q.pop();
            for (auto it : adjList[node]) {
                if (!vis[it]) {
                    vis[it] = 1;
                    q.push({it,node});
                } else if (it != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    bool isCycle(vector<vector<int>>& adj) {
        int V = adj.size();
        unordered_map<int,vector<int>> adjList;
        for (int i = 0;i<V;i++) {
            adjList.insert({i,adj[i]});
        }
        vector<int> vis(V,0);
        for (int i = 0;i < V;i++) {
            if(!vis[i]) {
                if(bfs(i, adjList, vis)) return true;
            }
        }
        return false;
    }
};

// DFS Approach
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    bool dfs(int src, unordered_map<int,vector<int>>& adjList, int parent, vector<int>& vis) {
        vis[src] = 1;
        for (auto& it : adjList[src]) {
            if (!vis[it]) {
                if(dfs(it, adjList, src, vis)) return true;
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }
    
    bool isCycle(vector<vector<int>>& adj) {
        int V = adj.size();
        unordered_map<int,vector<int>> adjList;
        for (int i = 0;i<V;i++) {
            adjList.insert({i,adj[i]});
        }
        vector<int> vis(V,0);
        for (int i = 0;i < V;i++) {
            if(!vis[i]) {
                if(dfs(i, adjList, -1, vis)) return true;
            }
        }
        return false;
    }
};