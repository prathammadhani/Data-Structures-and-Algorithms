//Problem Name: Detect Cycles in 2D Grid
//Problem Link: https://leetcode.com/problems/detect-cycles-in-2d-grid/

class Solution {
public:
    int dx[4] = {0, -1, 0, 1};
    int dy[4] = {-1, 0, 1, 0};
    bool dfs(int x, int y, int px, int py, vector<vector<char>>&grid, vector<vector<int>>& vis) {
        vis[x][y] = 1;
        int m = grid.size();
        int n = grid[0].size();
        for(int k = 0;k<4;k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
            if(grid[nx][ny]!=grid[x][y]) continue;
            if(vis[nx][ny] && !(nx == px && ny == py)) return true;
            if(!vis[nx][ny]) {
                if(dfs(nx,ny,x,y,grid,vis)) return true;
            }
        }
        return false;
    }

    bool containsCycle(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> vis(m, vector<int>(n, 0));
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(!vis[i][j]) {
                    if(dfs(i,j,-1,-1,grid,vis))
                        return true;
                }
            }
        }
        return false;
    }
};