class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, res = nums[n - 1] - nums[0];
        
        for(int i=0; i<n-1; i++){
            int mx=Math.max(nums[n-1]-k, nums[i]+k);
            int mn=Math.min(nums[0]+k, nums[i+1]-k);
            res=Math.min(res, mx-mn);
        }
        return res;
        /*
        for (int i = 0; i < n - 1; ++i) {
            mx = Math.max(mx, nums[i] + 2 * k);
            mn = Math.min(nums[i + 1], nums[0] + 2 * k);
            res = Math.min(res, mx - mn);
        }
        return res;
        */
    }
}