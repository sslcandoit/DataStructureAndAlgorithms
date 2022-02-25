class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i=0; i<n; i++) nums[i+n]=nums[i+n]|(nums[i]<<10);
        for(int i=0; i<n; i++){
            nums[i*2]=(nums[i+n]& 0xFFC00)>>10;
            nums[i*2+1]=nums[i+n]& 0x3FF;
        }
        return nums;
    }
}
