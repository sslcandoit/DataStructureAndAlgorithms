class Solution {
    public void sortColors(int[] nums) {
        int zero=-1, i=0, two=nums.length;
        while(i<two){
            if(nums[i]==0){
                zero++;
                swap(nums, zero, i);
                i++;
            }else if(nums[i]==2){
                two--;
                swap(nums, two, i);
            }else i++;
        } 
    }
    private void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}