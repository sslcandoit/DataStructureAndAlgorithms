class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        
        int l, r;
        for(l=2, r=2; r<len; r++){
            if(nums[r]==nums[l-2]) continue;
            
            nums[l++]=nums[r];
        }
        return l;
    }
}