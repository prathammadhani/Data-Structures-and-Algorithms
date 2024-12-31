// Problem Name: Number Of Enclaves
// Problem Link: https://www.geeksforgeeks.org/problems/number-of-enclaves/0 / https://leetcode.com/problems/number-of-enclaves/

class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void dfs(int i, int j, int[][] grid, int[][] vis) {
        vis[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int row = i + dx[k];
            int col = j + dy[k];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && vis[row][col] == 0
                    && grid[row][col] == 1) {
                dfs(row, col, grid, vis);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        // First Column
        for (int i = 0; i < m; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, grid, vis);
            }
        }
        // Last Column
        for (int i = 0; i < m; i++) {
            if (vis[i][n - 1] == 0 && grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid, vis);
            }
        }
        // First Row
        for (int j = 0; j < n; j++) {
            if (vis[0][j] == 0 && grid[0][j] == 1) {
                dfs(0, j, grid, vis);
            }
        }
        // Last Row
        for (int j = 0; j < n; j++) {
            if (vis[m - 1][j] == 0 && grid[m - 1][j] == 1) {
                dfs(m - 1, j, grid, vis);
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}