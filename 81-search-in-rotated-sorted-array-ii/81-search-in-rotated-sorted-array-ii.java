class Solution {
    public boolean search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]==target) return true;
            else if(nums[m]==nums[l]) l++;
            else if(nums[m]==nums[r]) r--;
            else if(nums[l]<nums[m]){
                if(nums[l]<=target && target<=nums[m]) r=m;
                else l=m;
            }else if(nums[m]<nums[r]){
                if(nums[m]<=target && target<=nums[r]) l=m;
                else r=m;
            }
        }
        if(nums[l]==target || nums[r]==target) return true;
        return false;
    }
}