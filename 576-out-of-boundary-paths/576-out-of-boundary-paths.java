class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        int[][] dp=new int[m][n];
        dp[startRow][startColumn]=1;
        
        int ans=0, mod=1000000007;
        
        for(int step=1; step<=maxMove; step++){
            
            int[][] temp=new int[m][n];
            
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    
                    for(int[] dir:dirs){
                        int x=dir[0]+i;
                        int y=dir[1]+j;

                        if(x>=0 && x<m && y>=0 && y<n) temp[x][y]=(temp[x][y]+dp[i][j])%mod;
                        else ans= (ans+dp[i][j])%mod;
                    }
                } 
            }
            dp=temp;
        }
        return (int)ans;
    }
}