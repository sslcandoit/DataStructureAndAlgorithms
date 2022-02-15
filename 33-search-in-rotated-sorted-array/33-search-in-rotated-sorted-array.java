class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1 && nums[0] !=target) return -1;
        else if(nums.length==1 && nums[0]==target) return 0;
        
        int l=0;
        int r=nums.length;
        int peakIndex=findPeak(nums, l, r-1);
        if(nums[peakIndex]==target) return peakIndex;
        else if(target>=nums[l] && target<nums[peakIndex]) return binarySearch(nums, l, peakIndex, target);
        else return binarySearch(nums, peakIndex+1, r, target);
    }
    private int findPeak(int[] nums, int l, int r){
        if(nums[l]<nums[r]) return r;
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]>nums[m+1]) return m;
            else if(nums[m]>nums[l]) l=m+1;
            else r=m;
        }
        return -1;
    }
    private int binarySearch(int[] nums, int l, int r, int target){
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]==target) return m;
            else if(nums[m]>target) r=m;
            else l=m+1;
        }
        return -1;
    }
}