class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2 !=0) return false;
        
        sum=sum/2;
        
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        
        for(int num:nums){
            for(int i=sum; i>=1 && i>=num; i--){
                dp[i]=dp[i] || dp[i-num];
                if(dp[sum]==true) return true;
            }
        }
        return false;
    }
}