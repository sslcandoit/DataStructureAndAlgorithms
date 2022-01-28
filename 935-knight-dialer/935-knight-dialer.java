class Solution {
    public int knightDialer(int n) {
        int mod=(int) 1e9+7;
        int[][] dias={{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        
        int[] dp=new int[10];
        Arrays.fill(dp, 1);
        
        for(int i=2; i<=n; i++){
            int[] temp=new int[10];
            for(int k=0; k<dias.length; k++){
                int[] dia=dias[k];
                for(int d:dia) temp[k]=(temp[k]+dp[d])%mod;
            }
            dp=temp;
        }
        int ans=0;
        for(int v:dp) ans=(ans+v)%mod;
        return ans;
    }
}