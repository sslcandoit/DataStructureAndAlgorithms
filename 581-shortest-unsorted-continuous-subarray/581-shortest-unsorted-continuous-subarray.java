class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int m=nums.length;
        int max=nums[0], min=nums[m-1];
        int start=-1, end=-2;
        for(int i=1; i<m; i++){
            max=Math.max(max, nums[i]);
            min=Math.min(min, nums[m-1-i]);
            if(nums[i]<max) end=i;
            if(nums[m-1-i]>min) start=m-1-i;
        }
        return end-start+1;
    }
}