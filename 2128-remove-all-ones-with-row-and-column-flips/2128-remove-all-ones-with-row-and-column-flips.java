class Solution {
    public boolean removeOnes(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        
        IntStream.range(0, n).forEach(j -> {
            if(grid[0][j]==1){
                IntStream.range(0, m).forEach(i ->{
                    grid[i][j]=1-grid[i][j];
                });
            }
        });
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(grid[i][j] !=grid[i][j-1]) return false;
            }
        }
        return true;
    }
}