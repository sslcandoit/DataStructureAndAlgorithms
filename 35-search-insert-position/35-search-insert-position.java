class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]==target) return m;
            else if(nums[m]>target) r=m;
            else l=m+1;
        }
        return l;
        
        /*
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return l;
        */
    }
}