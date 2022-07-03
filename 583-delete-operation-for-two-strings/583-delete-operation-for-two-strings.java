class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp=new int[m+1][n+1];
        
        for(int i=0; i<m; i++){
            char c1=word1.charAt(i);
            for(int j=0; j<n; j++){
                char c2=word2.charAt(j);
                
                if(c1==c2) dp[i+1][j+1]=dp[i][j]+1;
                else dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return m+n-(dp[m][n])*2;
    }
}