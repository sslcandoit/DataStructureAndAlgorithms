class Solution {
    private int dp[][];
    public int superEggDrop(int k, int n) {
        this.dp=new int[k+1][n+1];
        for(int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);
        return helper(k, n);
    }
    private int helper(int k, int n){
        if(dp[k][n] !=Integer.MAX_VALUE) return dp[k][n];
        if(k==0) return 0;
        if(k==1 || n<=1) return n;
        
        int l=1, r=n+1;
        while(l<r){
            int m=l+(r-l)/2;
            if(helper(k-1, m-1) >=helper(k, n-m)) r=m;
            else l=m+1;
        }
        dp[k][n]=1+Math.max(helper(k-1, l-1), helper(k, n-l));
        return dp[k][n];
    }
}