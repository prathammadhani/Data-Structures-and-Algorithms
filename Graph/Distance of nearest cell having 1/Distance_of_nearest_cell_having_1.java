// Problem Name: 01 Matrix
// Problem Link: https://leetcode.com/problems/01-matrix/

class Pair {
    int first, second, third;
    public Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1) {
                    vis[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.first;
            int col = pair.second;
            int dist = pair.third;
            dis[row][col] = dist;
            for(int k = 0;k<4;k++){
                int newRow = row + dx[k];
                int newCol = col + dy[k];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Pair(newRow, newCol, dist + 1));
                }
            }
        }
        return dis;
    }
    
}