// Problem Name: 01 Matrix
// Problem Link: https://leetcode.com/problems/01-matrix/

class Solution {
  public:
    // Function to find distance of nearest 1 in the grid for each cell.
    vector<vector<int>> nearest(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dis(n, vector<int>(m,0));
        vector<vector<int>> vis(n, vector<int>(m,0));
        queue<pair<pair<int,int>,int>> q;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    q.push({{i,j},0});
                    vis[i][j] = 1;
                }
            }
        }
        int dx[4] = {-1,0,1,0};
        int dy[4] = {0,1,0,-1};
        while(!q.empty()) {
            auto node = q.front();
            q.pop();
            int x = node.first.first;
            int y = node.first.second;
            int dist = node.second;
            dis[x][y] = dist;
            for (int k = 0;k<4;k++) {
                int row = x + dx[k];
                int col = y + dy[k];
                if (row>=0 && row<n && col>=0 && col<m && !vis[row][col]) {
                    vis[row][col] = 1;
                    q.push({{row,col},dist+1});
                }
            }
        }
        return dis;
    }
};