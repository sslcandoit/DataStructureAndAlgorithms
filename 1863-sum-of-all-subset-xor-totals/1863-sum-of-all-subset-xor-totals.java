class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    public int helper(int[] nums, int index, int pre){
        if(index>=nums.length) return pre;
        return helper(nums, index+1, pre^nums[index])+helper(nums, index+1, pre);
    }
}