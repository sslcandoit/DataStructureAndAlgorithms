class Solution {
    public int numTilings(int n) {
        long[][] dp=new long[n+1][2];
        dp[0][0]=1;
        dp[1][0]=1;
        for(int i=2; i<=n; i++){
            dp[i][0]=(dp[i-1][0]+dp[i-2][0]+2*dp[i-1][1])%1000000007;
            dp[i][1]=(dp[i-2][0]+dp[i-1][1])%1000000007;
        }
        return (int)dp[n][0];
    }
}