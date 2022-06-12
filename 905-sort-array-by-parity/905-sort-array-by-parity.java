class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        while(l<r){
            while(l<r && nums[l]%2==0) l++;
            while(l<r && nums[r]%2==1) r--;
            swap(nums, l, r);
        }
        return nums;
    }
    private void swap(int[] nums, int l, int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}