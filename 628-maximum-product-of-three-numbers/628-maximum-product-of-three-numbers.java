class Solution {
    public int maximumProduct(int[] nums) {
        //【-5，-4，0，2，6，8】
        Arrays.sort(nums);
        int n=nums.length-1;
        
        int max1=nums[n], max2=nums[n-1], max3=nums[n-2];
        int min1=nums[0], min2=nums[1];
        
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}