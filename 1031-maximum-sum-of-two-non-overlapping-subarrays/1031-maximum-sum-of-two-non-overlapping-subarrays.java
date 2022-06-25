class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] sum=new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            sum[i+1]=sum[i]+nums[i];
        }
        return Math.max(helper(sum, firstLen, secondLen), helper(sum, secondLen, firstLen));
    }
    private int helper(int[] nums, int f, int s){
        int n=nums.length, maxF=0, maxSum=0;
        for(int i=f+s; i<n; i++){
            maxF=Math.max(maxF, nums[i-s]-nums[i-s-f]);
            maxSum=Math.max(maxSum, maxF+(nums[i]-nums[i-s]));
        }
        return maxSum;
    }
}