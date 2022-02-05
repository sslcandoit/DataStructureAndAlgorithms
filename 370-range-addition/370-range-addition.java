class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] dp=new int[length];
        
        for(int[] u:updates){
            dp[u[0]]+=u[2];
            if(u[1]+1<length) dp[u[1]+1]-=u[2];
        }
        for(int i=1; i<length; i++) dp[i]+=dp[i-1];
        return dp;
    }
}