class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b)-> a[0]-b[0]);
        
        long[] dp=new long[n+1];
        int j=0;
        for(int i=1; i<=n; i++){
            dp[i]=Math.max(dp[i], dp[i-1]);
            while(j<rides.length && rides[j][0]==i){
                int earning=rides[j][1]-rides[j][0]+rides[j][2];
                int endPoint=rides[j++][1];
                dp[endPoint]=Math.max(dp[endPoint], dp[i]+earning);
            }
        }
        return dp[n];
    }
}