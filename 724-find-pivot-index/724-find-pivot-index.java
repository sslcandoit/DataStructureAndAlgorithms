class Solution {
    public int pivotIndex(int[] nums) {
        int r=Arrays.stream(nums).sum(), l=0;
        
        for(int i=0; i<nums.length; i++){
            r-=nums[i];
            if(l==r) return i;
            l+=nums[i];
        }
        return -1;
    }
}