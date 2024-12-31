// Problem Name: Replace O's with X's / Surrounded Regions
// Problem Link: https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1 / https://leetcode.com/problems/surrounded-regions/description/

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void dfs(int i, int j, char[][] mat, int[][] vis) {
        vis[i][j] = 1;
        for(int k = 0;k<4;k++){
            int row = i + dx[k];
            int col = j + dy[k];
            if(row>=0 && row<mat.length && col>=0 && col<mat.length && vis[row][col] == 0 && mat[row][col] == 'O') {
                dfs(row, col, mat, vis);
            }
        }
    }
    
    static char[][] fill(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        char[][] ans = new char[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans[i][j] = mat[i][j];
            }
        }
        //First Column
        for(int i = 0;i<n;i++){
            if(mat[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i,0,mat,vis);
            }
        }
        //Last Column
        for(int i = 0;i<n;i++){
            if(mat[i][m-1] == 'O' && vis[i][m-1] == 0) {
                dfs(i,m-1,mat,vis);
            }
        }
        //First row
        for(int j = 0;j<m;j++){
            if(mat[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0,j,mat,vis);
            }
        }
        //Last row
        for(int j = 0;j<m;j++){
            if(mat[n-1][j] == 'O' && vis[n-1][j] == 0) {
                dfs(n-1,j,mat,vis);
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 'O' && vis[i][j] == 0) {
                    ans[i][j] = 'X';
                }
            }
        }
        return ans;
    }
}