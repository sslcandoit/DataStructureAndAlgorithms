class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int n=nums.length, left, right;
        int[] index=new int[2];
        for(int i=0; i<n; i++){
            left= (i>0)? nums[i-1]:1001;
            right= (i==n-1)? 1001:nums[i+1];
            index[i%2]+=Math.max(0, nums[i]-Math.min(left, right)+1);
        }
        return Math.min(index[0], index[1]);
    }
    /*
         [8,0,9] or [1,9,0]
    */
}