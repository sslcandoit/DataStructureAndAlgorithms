class Solution {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int area=0, neb=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    area++;
                    if(i+1<m && grid[i+1][j]==1) neb++;
                    if(i-1>=0 && grid[i-1][j]==1) neb++;
                    if(j+1<n && grid[i][j+1]==1) neb++;
                    if(j-1>=0 && grid[i][j-1]==1) neb++;
                } 
            }
        }
        return area*4-neb;
    }
}