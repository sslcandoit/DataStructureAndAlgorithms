class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n=nums.length;
        double[][] dp=new double[n+1][k+1];
        
        double sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            dp[i+1][1]=sum/(i+1);
        }
        return helper(dp, nums, n, k);
    }
    
    private double helper(double[][] dp, int[] nums, int n, int k){
        if(n<k) return 0;
        if(dp[n][k]>0) return dp[n][k];
        
        double sum=0;
        for(int i=n-1; i>0; i--){
            sum+=nums[i];
            dp[n][k]=Math.max(dp[n][k], helper(dp, nums, i, k-1)+sum/(n-i));
        }
        return dp[n][k];
    }    
}