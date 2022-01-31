class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        
        for(int i=1; i<=n; i++){
            int curMax=0;
            for(int j=1; j<=i && j<=k; j++){
                curMax=Math.max(curMax, arr[i-j]);
                dp[i]=Math.max(dp[i], dp[i-j]+curMax*j);
            }
        }
        return dp[n];
    }
}