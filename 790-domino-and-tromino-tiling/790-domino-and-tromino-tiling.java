class Solution {
    public int numTilings(int n) {
        long[] dp=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        if(n==1) return 1;
        dp[2]=2;
        if(n==2) return 2;
        dp[3]=5;
        if(n==3) return 5;
        for(int i=4; i<=n; i++){
            dp[i]=(2*dp[i-1]+dp[i-3])%1000000007;
        }
        return (int)dp[n];
    }
    /*
     int md=1e9;
    md+=7;
    vector<long long> v(1001,0);
    v[1]=1;
    v[2]=2;
    v[3]=5;
    if(N<=3)
        return v[N];
    for(int i=4;i<=N;++i){
        v[i]=2*v[i-1]+v[i-3]; 
        v[i]%=md;
    }
    return v[N];
    /*
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
    */
}