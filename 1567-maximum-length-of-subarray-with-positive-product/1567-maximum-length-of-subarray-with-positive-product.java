class Solution {
    public int getMaxLen(int[] nums) {
        int firstNegIndex=-1, zeroIndex=-1, countNeg=0, ans=0;
        
        for(int i=0; i<nums.length; i++){
            int cur=nums[i];
            if(cur<0){
                countNeg++;
                if(firstNegIndex==-1) firstNegIndex=i;
            }else if(cur==0){
                firstNegIndex=-1;
                zeroIndex=i;
                countNeg=0;
            }
            if(countNeg%2==0) ans=Math.max(i-zeroIndex, ans);
            else ans=Math.max(i-firstNegIndex, ans);
        }
        return ans;
    }
}