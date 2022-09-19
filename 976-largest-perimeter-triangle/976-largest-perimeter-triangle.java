class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        int len=nums.length;
        for(int i=len-1; i>=2; i--){
            if(nums[i-1]+nums[i-2]>nums[i]){
                return nums[i-1]+nums[i-2]+nums[i];
            }
        }
        return 0;
    }
}