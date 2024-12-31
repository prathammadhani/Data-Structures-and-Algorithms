// Problem Name: Number Of Enclaves
// Problem Link: https://www.geeksforgeeks.org/problems/number-of-enclaves/0

class Solution {
  public:
    int dx[4] = {-1,0,1,0};
    int dy[4] = {0,1,0,-1};
    void dfs(int i,int j,vector<vector<int>>& grid,vector<vector<int>>& vis){
        vis[i][j] = 1;
        for(int k = 0;k<4;k++){
            int row = i+dx[k];
            int col = j+dy[k];
            if(row>=0 && row<grid.size() && col>=0 && col<grid[0].size() && !vis[row][col] && grid[row][col]==1){
                dfs(row,col,grid,vis);
            }
        }
    }
    
    int numberOfEnclaves(vector<vector<int>> &grid) {
        // Code here
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        // First row
        for(int i = 0;i<m;i++){
            if(!vis[0][i] && grid[0][i]==1){
                dfs(0,i,grid,vis);
            }
        }
        
        // Last row
        for(int i = 0;i<m;i++){
            if(!vis[n-1][i] && grid[n-1][i]==1){
                dfs(n-1,i,grid,vis);
            }
        }
        
        // First col
        for(int i = 0;i<n;i++){
            if(!vis[i][0] && grid[i][0]==1){
                dfs(i,0,grid,vis);
            }
        }
        
        // Last col
        for(int i = 0;i<n;i++){
            if(!vis[i][m-1] && grid[i][m-1]==1){
                dfs(i,m-1,grid,vis);
            }
        }
        
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
};