class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        int[] dp=new int[n];
        int ans=0;
        for(int num:nums){
            int index=Arrays.binarySearch(dp, 0, ans, num);
            if(index<0) index=-(index+1);
            dp[index]=num;
            if(index==ans) ans++;
        }
        return ans;
        /*
        int n=nums.length;
        int[] dp=new int[n];
        
        int max=0;
        for(int i=0; i<n; i++){
            int len=1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]) len=Math.max(len, dp[j]+1);
            }
            dp[i]=len;
            if(len>max) max=len;
        }
        return max;
        */
    }
}