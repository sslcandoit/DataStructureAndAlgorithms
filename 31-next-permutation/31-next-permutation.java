class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                int j=i+1;
                while(j<n && nums[j]>nums[i]) j++;
                
                swap(nums, i, j-1);
                reverse(nums, i+1, n-1);
                return;
            }
        }
        reverse(nums, 0, n-1);
    }
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums, int l, int r){
        while(l<r) swap(nums, l++, r--);
    }
}