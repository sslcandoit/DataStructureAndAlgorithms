class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l=0, r=nums.length-1;
        while(l<r){
            int pivot_index=quickSort(nums, l, r);
            if(pivot_index+1==k) return nums[pivot_index];
            else if(pivot_index+1>k) r=pivot_index-1;
            else l=pivot_index+1;
        }
        return nums[k-1];
    }
    private int quickSort(int[] nums, int l, int r){
        int pivot=nums[l];
        while(l<r){
            while(l<r && nums[r]<=pivot) r--;
            nums[l]=nums[r];
            while(l<r && nums[l]>=pivot) l++;
            nums[r]=nums[l];
        }
        nums[l]=pivot;
        return l;
    }
}