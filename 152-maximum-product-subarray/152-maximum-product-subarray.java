class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i=1; i<nums.length; i++){
            int num=nums[i];
            int oldMax=max;
            max=Math.max(num, Math.max(max*num, min*num));
            min=Math.min(num, Math.min(oldMax*num, min*num));
            ans=Math.max(ans, max);
        }
        return ans;
    }
}