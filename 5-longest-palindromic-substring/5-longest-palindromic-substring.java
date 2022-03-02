class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        String ans="";
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
               if(i==j) dp[i][j]=true;
               else if(s.charAt(i) !=s.charAt(j)) dp[i][j]=false;
               else{
                   dp[i][j]=true;
                   if(i-1>j+1) dp[i][j]=dp[i-1][j+1];
               }
               if(dp[i][j]==true && ans.length()<i-j+1) ans=s.substring(j, i+1);
            }
        }
        return ans;
    }
}