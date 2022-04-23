class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        if(k==0 || k%len==0) return;
        
        k=k%len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    private void reverse(int[] nums, int l, int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}