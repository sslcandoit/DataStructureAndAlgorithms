class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        
        int[] dp=new int[n+1];
        int pre=0;
        int res=0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(dp[j], dp[j-1]), pre)+1;
                    res=Math.max(res, dp[j]);
                }else dp[j]=0;
                pre=temp;
            }
        }
        return res*res;
    }
}