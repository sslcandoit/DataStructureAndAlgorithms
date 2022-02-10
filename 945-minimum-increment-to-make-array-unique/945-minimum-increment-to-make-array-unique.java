class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count=0, need=nums[0]+1;
        for(int i=1; i<nums.length; i++){
           count+=Math.max(0, need-nums[i]);
           need=Math.max(need, nums[i])+1;
        }
        return count;
    }
}