class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int m=grid.length, n=grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid, i, j);
                } 
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int i, int j){
        grid[i][j]='0';
        if(i+1<grid.length && grid[i+1][j]=='1') dfs(grid, i+1, j);
        if(i-1>=0 && grid[i-1][j]=='1') dfs(grid, i-1, j);
        if(j+1<grid[0].length && grid[i][j+1]=='1') dfs(grid, i, j+1);
        if(j-1>=0 && grid[i][j-1]=='1') dfs(grid, i, j-1);
    }
}