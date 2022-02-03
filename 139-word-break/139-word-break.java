class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        
        for(int i=0; i<n; i++){
            if(!dp[i]) continue;
            for(String str:wordDict){
                int j=i+str.length();
                if(j<=n && s.substring(i, j).equals(str)) dp[j]=true;
            }
        }
        return dp[n];
    }
}