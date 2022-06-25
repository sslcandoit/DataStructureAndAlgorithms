class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new int[nums.length][nums.length])>=0;
    }
    private int helper(int[] nums, int l, int r, int[][] memo){
        if(memo[l][r]==0){
            memo[l][r]= (l==r? nums[l]:
                         Math.max(nums[l]-helper(nums, l+1, r, memo), 
                                  nums[r]-helper(nums, l, r-1, memo)));
        }
        return memo[l][r];
    }
}