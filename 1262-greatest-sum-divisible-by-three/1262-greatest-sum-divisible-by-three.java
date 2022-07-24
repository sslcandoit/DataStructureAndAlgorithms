class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp=new int[3];
        
        for(int n:nums){
            
            int[] copy=Arrays.copyOf(dp, 3);
            
            for(int curSum:copy){
                dp[(n+curSum)%3]=Math.max(dp[(n+curSum)%3], n+curSum);
            }
        }
        return dp[0];
    }
}