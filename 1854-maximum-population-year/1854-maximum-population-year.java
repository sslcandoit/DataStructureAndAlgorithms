class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] dp=new int[2051];
        for(int[] l:logs){
            dp[l[0]]++;
            dp[l[1]]--;
        }
        
        int res=0;
        for(int i=1950; i<=2050; i++){
            dp[i]+=dp[i-1];
            res= (dp[i]>dp[res])? i:res;
        }
        return res;
    }
}