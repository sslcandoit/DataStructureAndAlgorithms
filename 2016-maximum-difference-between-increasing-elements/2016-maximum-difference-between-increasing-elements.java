class Solution {
    public int maximumDifference(int[] nums) {
        int ans=-1, before=nums[0], m=nums.length;
        for(int i=1; i<m; i++){
            if(nums[i]>before) ans=Math.max(ans, nums[i]-before);
            else before=nums[i];
        }
        return ans;
    }
}