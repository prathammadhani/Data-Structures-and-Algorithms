// Problem Name: Detect Cycle in Undirected Graph
// Problem Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

// BFS Approach
class Pair {
    public int first,second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src] = true;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(new Pair(it,node));
                } else if (it != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V;i++) vis[i] = false;
        for (int i = 0; i < V;i++) {
            if (vis[i] == false) {
                if (bfs(i, adj, vis)) return true;
            }
        }
        return false;
    }
}

// DFS Approach
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(int src, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        for (Integer it : adj.get(src)) {
            if (vis[it] == false) {
                if(dfs(it, src, vis, adj)) return true;
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V;i++) vis[i] = false;
        for (int i = 0; i < V;i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
}