class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0;
        for(int i=0, j=0; i<nums.length; i++){
            if(nums[i]==0) k--;
            while(k<0){
                if(nums[j]==0) k++;
                j++;
            }
            ans=Math.max(ans, i-j+1);
        }
        return ans;
    }
}