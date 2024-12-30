// Problem Name: Rotten Oranges
// Problem Link: https://www.geeksforgeeks.org/problems/rotten-oranges2536/1

class Pair {
    int first, second, third;
    public Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        int[][] vis = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int ans = 0, cnt = 0;
        int[] dx = { -1 , 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.first;
            int y = curr.second;
            int time = curr.third;
            ans = Math.max(ans,time);
            for(int k = 0;k<4;k++){
                int row = x + dx[k];
                int col = y + dy[k];
                if(row>=0 && row<m && col>=0 && col<n && vis[row][col] == 0 && grid[row][col] == 1){
                    vis[row][col] = 2;
                    q.add(new Pair(row,col,time + 1));
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return ans;
    }
}