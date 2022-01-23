class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        int maxArea=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) maxArea=Math.max(maxArea, dfs(grid, dirs, i, j));
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int[][] dirs, int i, int j){
        int count=1;
        grid[i][j]=-1;
        for(int[] dir: dirs){
            int x=dir[0]+i;
            int y=dir[1]+j;
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                count+=dfs(grid, dirs, x, y);
            } 
        }
        return count;
    }
}