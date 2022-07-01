class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                             
        for(int i=1; i<nums.length && cnt<=1; i++){
            if(nums[i]<nums[i-1]){
                cnt++;
                if(i-2<0 || nums[i-2]<=nums[i]) nums[i-1]=nums[i];
                else nums[i]=nums[i-1];
            }
        }
        return cnt<=1;
    }
}//[3,4,2,3]    [4,2,3]
// [3,4,4,4]    [2,2,3]