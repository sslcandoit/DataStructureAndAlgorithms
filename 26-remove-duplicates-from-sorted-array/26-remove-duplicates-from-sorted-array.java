class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, l=0, r=0;
        while(r<nums.length){
            while(r<nums.length && nums[r]==nums[l]) r++;
            nums[i++]=nums[l];
            l=r;
        }
        return i;
    }
}