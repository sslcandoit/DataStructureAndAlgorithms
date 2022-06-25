class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int m=nums.length;
        int[][] dp=new int[m][m];
        
        for(int i=0; i<m; i++) dp[i][i]=nums[i];
        
        for(int i=0; i<m-1; i++) dp[i][i+1]=Math.max(nums[i], nums[i+1]);
        
        for(int len=3; len<=m; len++){
            for(int l=0; l+len-1<m; l++){
                int r=l+len-1;
                
                int left=nums[l]+Math.min(dp[l+1][r-1], dp[l+2][r]);
                int right=nums[r]+Math.min(dp[l+1][r-1], dp[l][r-2]);
                
                dp[l][r]=Math.max(left, right);
            }
        }
        int sum=Arrays.stream(nums).sum();
        return 2*dp[0][m-1]>=sum;
    }
    /*
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new int[nums.length][nums.length])>=0;
    }
    private int helper(int[] nums, int l, int r, int[][] memo){
        if(memo[l][r]==0){
            memo[l][r]= (l==r? nums[l]:
                         Math.max(nums[l]-helper(nums, l+1, r, memo), 
                                  nums[r]-helper(nums, l, r-1, memo)));
        }
        return memo[l][r];
    }
    */
}