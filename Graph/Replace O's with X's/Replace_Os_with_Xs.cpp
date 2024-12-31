// Problem Name: Replace O's with X's / Surrounded Regions
// Problem Link: https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1 / https://leetcode.com/problems/surrounded-regions/description/

class Solution {
  public:
    int dx[4] = {-1,0,1,0};
    int dy[4] = {0,1,0,-1};
    void dfs(int i,int j,vector<vector<char>>& mat,vector<vector<int>>& vis) {
        vis[i][j] = 1;
        for(int k = 0;k<4;k++){
            int row = i + dx[k];
            int col = j + dy[k];
            if(row>=0 && row<mat.size() && col>=0 && col<mat[0].size() && !vis[row][col] && mat[row][col] == 'O'){
                dfs(row,col,mat,vis);
            }
        }
    }
    
    vector<vector<char>> fill(vector<vector<char>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        vector<vector<int>> vis(n,vector<int>(m,0));
        vector<vector<char>> ans = mat;
        //First Column
        for(int i = 0;i<n;i++){
            if(mat[i][0] == 'O' && !vis[i][0]) {
                dfs(i,0,mat,vis);
            }
        }
        //Last Column
        for(int i = 0;i<n;i++){
            if(mat[i][m-1] == 'O' && !vis[i][m-1]) {
                dfs(i,m-1,mat,vis);
            }
        }
        //First row
        for(int j = 0;j<m;j++){
            if(mat[0][j] == 'O' && !vis[0][j]) {
                dfs(0,j,mat,vis);
            }
        }
        //Last row
        for(int j = 0;j<m;j++){
            if(mat[n-1][j] == 'O' && !vis[n-1][j]) {
                dfs(n-1,j,mat,vis);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 'O' && !vis[i][j]) {
                    ans[i][j] = 'X';
                }
            }
        }
        return ans;
    }
    
};