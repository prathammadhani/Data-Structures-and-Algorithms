// Problem Name: LC - 200. Number of Islands
// Problem Link: https://leetcode.com/problems/number-of-islands/

// BFS Approach
class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    public void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
        while (!q.isEmpty()) {
            Pair currNode = q.poll();
            int x = (int) currNode.getKey();
            int y = (int) currNode.getValue();
            for (int k = 0; k < 4; k++) {
                int row = x + dx[k];
                int col = y + dy[k];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && vis[row][col] == false
                        && grid[row][col] == '1') {
                    vis[row][col] = true;
                    q.add(new Pair(row, col));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
}

// DFS Approach
class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    public void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int row = i + dx[k];
            int col = j + dy[k];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && vis[row][col] == false
                    && grid[row][col] == '1') {
                dfs(row,col,grid,vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
}