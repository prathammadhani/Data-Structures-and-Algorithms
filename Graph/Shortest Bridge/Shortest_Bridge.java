// Problem Name: Shortest Bridge
// Problem Link: https://leetcode.com/problems/shortest-bridge/description/

class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void dfs(int i, int j, int[][] grid, int[][] vis, Queue<Pair> q) {
        vis[i][j] = 1;
        q.add(new Pair(i, j));
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && vis[x][y] == 0 && grid[x][y] == 1) {
                dfs(x, y, grid, vis, q);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][n];
        boolean flag = false;
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
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                Pair curr = q.poll();
                int x = (int) curr.getKey();
                int y = (int) curr.getValue();
                for (int k = 0; k < 4; k++) {
                    int row = x + dx[k];
                    int col = y + dy[k];
                    if (row >= 0 && row < n && col >= 0 && col < n && vis[row][col] == 0) {
                        if (grid[row][col] == 1)
                            return ans;
                        vis[row][col] = 1;
                        q.add(new Pair(row, col));
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}