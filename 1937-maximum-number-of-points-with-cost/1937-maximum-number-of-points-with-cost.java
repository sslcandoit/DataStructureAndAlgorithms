class Solution {
    public long maxPoints(int[][] points) {
        int m=points.length, n=points[0].length;
        long[] dp=new long[n];
        
        long ans=0;
        for(int i=0; i<m; i++){
            long[] cur=new long[n];
            
            long lmax=0;
            for(int j=0; j<n; j++){
                lmax=Math.max(lmax-1, dp[j]);
                cur[j]=lmax;
            }
            long rmax=0;
            for(int j=n-1; j>=0; j--){
                rmax=Math.max(rmax-1, dp[j]);
                cur[j]=Math.max(rmax, cur[j]);
                
                dp[j]=cur[j]+points[i][j];
                if(i==m-1) ans=Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}