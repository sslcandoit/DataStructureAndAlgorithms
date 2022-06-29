class Solution {
    public int minimumDeletions(String s) {
        int m= s.length();
	    int[] dp=new int[m+1];
        int bCount=0;
        for(int i=0; i<m; i++){
            if(s.charAt(i)=='a'){
                dp[i+1]=Math.min(dp[i]+1, bCount);
            }else{
                dp[i+1]=dp[i];
                bCount++;
            }
        }
        return dp[m];
    }
}
/*
"aaaaa"
"bbbbb"
"bbaaa"
*/