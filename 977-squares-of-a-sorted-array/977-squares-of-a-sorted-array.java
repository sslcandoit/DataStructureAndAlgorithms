class Solution {
    public int[] sortedSquares(int[] nums) {
        int len=nums.length;
        int[] ans=new int[len];
        int l=0, r=len-1, i=len-1;
        while(l<=r){
            int left=nums[l]*nums[l];
            int right=nums[r]*nums[r];
            if(right>=left){
                ans[i--]=right;
                r--;
            }else{
                ans[i--]=left;
                l++;
            } 
        }
        return ans;
    }
}