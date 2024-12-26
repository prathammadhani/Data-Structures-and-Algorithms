// Problem Name: LC - 200. Number of Islands
// Problem Link: https://leetcode.com/problems/number-of-islands/

// BFS Approach
class Solution {
public:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    void bfs(int i, int j, vector<vector<int>>& vis,
             vector<vector<char>>& grid) {
        queue<pair<int, int>> q;
        q.push({i, j});
        vis[i][j] = 1;
        while (!q.empty()) {
            auto node = q.front();
            q.pop();
            int x = node.first;
            int y = node.second;
            for (int k = 0; k < 4; k++) {
                int row = x + dx[k];
                int col = y + dy[k];
                if (row >= 0 && row < grid.size() && col >= 0 &&
                    col < grid[0].size() && !vis[row][col] &&
                    grid[i][j] == '1') {
                    vis[row][col] = true;
                    bfs(row, col, vis, grid);
                }
            }
        }
    }

    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        vector<vector<int>> vis(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    bfs(i, j, vis, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
};

// DFS Approach
class Solution {
public:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    void dfs(int i, int j, vector<vector<int>>& vis,
             vector<vector<char>>& grid) {
        vis[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.size() && y >= 0 && y < grid[0].size() &&
                !vis[x][y] && grid[x][y] == '1') {
                dfs(x, y, vis, grid);
            }
        }
    }

    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        vector<vector<int>> vis(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, vis, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
};