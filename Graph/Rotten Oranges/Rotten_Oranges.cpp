// Problem Name: LC - 994. Rotten Oranges
// Problem Link: https://leetcode.com/problems/rotting-oranges/

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int cntFresh = 0;
        queue<pair<pair<int,int>,int>> q;
        vector<vector<int>> vis(m,vector<int>(n,0));
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    q.push({{i,j},0});
                    vis[i][j] = 2;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int ans = 0, cnt = 0;
        int dx[4] = {-1,0,1,0};
        int dy[4] = {0,1,0,-1};
        while(!q.empty()){
            auto curr = q.front();
            q.pop();
            int x = curr.first.first;
            int y = curr.first.second;
            int time = curr.second;
            ans = max(ans,time);
            for(int k = 0;k<4;k++){
                int row = x + dx[k];
                int col = y + dy[k];
                if(row>=0 && row<m && col>=0 && col<n && !vis[row][col] && grid[row][col] == 1){
                    vis[row][col] = 2;
                    q.push({{row,col},time+1});
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return ans;
    }
};