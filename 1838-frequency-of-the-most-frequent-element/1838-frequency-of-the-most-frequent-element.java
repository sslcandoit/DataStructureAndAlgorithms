class Solution {
    public int maxFrequency(int[] nums, int k) {
        int ans=1;
        long sum=0;
        Arrays.sort(nums);
        
        for(int i=0, j=0; j<nums.length; j++){
            sum+=nums[j];
            while(sum+k<(long)nums[j]*(j-i+1)){
                sum-=nums[i];
                i++;
            }
            ans=Math.max(ans, j-i+1);
        }
        return ans;
    }
}