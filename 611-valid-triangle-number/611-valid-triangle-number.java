class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length;
        
        int ans=0;
        for(int i=size-1; i>=2; i--){
            int l=0, r=i-1;
            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    ans+=r-l;
                    r--;
                }else l++;
            }
        }
        return ans;
    }
}