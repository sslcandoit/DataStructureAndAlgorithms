class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length, count=1, ans=0;
        
        for(int i=2; i<n; i++){
            if(nums[i-1]-nums[i]==nums[i-2]-nums[i-1]){
                ans+=count;
                count++;
            }else{
                count=1;
            }
        }
        return ans;
    }
}