// Problem Name: Shortest Bridge
// Problem Link: https://leetcode.com/problems/shortest-bridge/description/

class Solution {
public:
    int dx[4] = {-1, 0, 1, 0};
    int dy[4] = {0, 1, 0, -1};
    void dfs(int i, int j, vector<vector<int>>& grid, vector<vector<int>>& vis,
             queue<pair<int, int>>& q) {
        vis[i][j] = 1;
        q.push({i, j});
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.size() && y >= 0 && y < grid.size() &&
                !vis[x][y] && grid[x][y] == 1) {
                dfs(x, y, grid, vis, q);
            }
        }
    }

    int shortestBridge(vector<vector<int>>& grid) {
        queue<pair<int, int>> q;
        int n = grid.size();
        vector<vector<int>> vis(n, vector<int>(n, 0));
        bool flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, vis, q);
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }

        int ans = 0;
        while (!q.empty()) {
            int sz = q.size();
            while (sz-- > 0) {
                auto curr = q.front();
                q.pop();
                int x = curr.first;
                int y = curr.second;
                for (int k = 0; k < 4; k++) {
                    int row = x + dx[k];
                    int col = y + dy[k];
                    if (row >= 0 && row < n && col >= 0 && col < n &&
                        !vis[row][col]) {
                        if (grid[row][col] == 1)
                            return ans;
                        vis[row][col] = 1;
                        q.push({row, col});
                    }
                }
            }
            ans++;
        }
        return ans;
    }
};