class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0) return 0;
        if(n==1) return nums[0];
        
        Arrays.sort(nums);
        int[] sum=new int[nums[n-1]+1];
        for(int num:nums) sum[num]+=num;
        
        int[] dp=new int[sum.length];
        dp[0]=sum[0];
        dp[1]=Math.max(sum[0], sum[1]);
        for(int i=2; i<sum.length; i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+sum[i]);
        }
        return dp[dp.length-1];
    }
}