class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for(int i=0; i<nums.length; i++){
            nums[i]=(nums[i]*nums[i]*a)+(nums[i]*b)+c;
        }
        Arrays.sort(nums);
        return nums;
    }
}