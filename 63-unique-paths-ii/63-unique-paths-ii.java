class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]==1) dp[j]=0;
                else if(j>0) dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
        */
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] dp=new int[m];
        dp[0]=1;
        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){
                if(obstacleGrid[i][j]==1) dp[i]=0;
                else if(i>0) dp[i]+=dp[i-1];
            }
        }
        return dp[m-1];
    }
    /*
    length=m
    col :1 1 1 -> 1 0 1 -> 1 1 2
    length=n
    row :1 1 1 -> 1 0 1 -> 1 1 2
    */
}