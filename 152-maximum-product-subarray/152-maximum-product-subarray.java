class Solution {
    public int maxProduct(int[] nums) {
        int l=0;
        int r=0;
        int n=nums.length;
        int max=nums[0];
        for(int i=0; i<n; i++){
            l=(l==0? 1:l)*nums[i];
            r=(r==0? 1:r)*nums[n-1-i];
            max=Math.max(max, Math.max(l, r));
        }
        return max;
        /*
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
        */
    }
}