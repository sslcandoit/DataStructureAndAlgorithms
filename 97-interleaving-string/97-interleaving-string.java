class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() !=s3.length()) return false;
        return dfs(s1, s2, s3, 0, 0, 0, new boolean[s1.length()+1][s2.length()+1]);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invaild){
        if(invaild[i][j]) return false;
        if(k==s3.length()) return true;
        boolean vaild=(i<s1.length() && s1.charAt(i)==s3.charAt(k) && dfs(s1, s2, s3, i+1, j, k+1, invaild))
            ||(j<s2.length() && s2.charAt(j)==s3.charAt(k) && dfs(s1, s2, s3, i, j+1, k+1, invaild));
        if(!vaild) invaild[i][j]=true;
        return vaild;
    }
    /*
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(), n=s2.length();
        if(m+n != s3.length()) return false;
        
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        
        for(int i=1; i<=m; i++) dp[i][0]=dp[i-1][0] && (s1.charAt(i-1)==s3.charAt(i-1));
        
        for(int j=1; j<=n; j++) dp[0][j]=dp[0][j-1] && (s2.charAt(j-1)==s3.charAt(j-1));
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                char c1=s1.charAt(i-1), c2=s2.charAt(j-1), c3=s3.charAt(i+j-1);
                dp[i][j]=((c1==c3 && dp[i-1][j])||(c2==c3 && dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
    */
}