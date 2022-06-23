class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length, n=grid[0].length, ans=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans=Math.max(ans, helper(grid, i, j));
            }
        }
        return ans;
    }
    private int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    private int helper(int[][] grid, int r, int c){
        int m=grid.length, n=grid[0].length, sum=0;
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]==0) return 0;
        
        int before=grid[r][c];
        grid[r][c]=0;
        
        for(int i=0; i<4; i++){
            sum=Math.max(sum, helper(grid, r+this.dirs[i][0], c+this.dirs[i][1]));
        }
        grid[r][c]=before;
        return sum+before;
    }
    /*
    [0, 6, 0]
    [5, 8, 7]
    [0, 9, 0]
    */
}