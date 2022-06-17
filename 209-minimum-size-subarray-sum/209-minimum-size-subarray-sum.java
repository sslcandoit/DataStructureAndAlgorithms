class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, n=nums.length, ans=n+1, sum=0;
        for(int r=0; r<n; r++){
            sum+=nums[r];
            while(sum>=target){
                ans=Math.min(ans, r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return ans==n+1? 0:ans;
    }
}