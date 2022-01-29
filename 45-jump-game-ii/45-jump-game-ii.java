class Solution {
    public int jump(int[] nums) {
        int max=0;
        int curMax=0;
        int res=0;
        for(int i=0; i<nums.length-1; i++){
            max=Math.max(max, i+nums[i]);
            if(i==curMax){
                res++;
                curMax=max;
            }
        }
        return res;
    }
}