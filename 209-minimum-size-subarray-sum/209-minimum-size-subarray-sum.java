class Solution {
    /*
    public int minSubArrayLen(int target, int[] nums) {//O(n)
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
    */
    public int minSubArrayLen(int target, int[] nums) {
        int l=1, r=nums.length, ans=0;
        while(l<=r){
            int m=l+(r-l)/2;
            if(helper(nums, target, m)){
                r=m-1;
                ans=m;
            }else l=m+1;
        }
        return ans;
    }
    private boolean helper(int[] nums, int target, int size){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(i>=size) sum-=nums[i-size];
            sum+=nums[i];
            if(sum>=target) return true;
        }
        return false;
    }
}