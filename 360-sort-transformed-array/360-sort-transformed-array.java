class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int m=nums.length;
        int[] ans=new int[m];
        int l=0, r=m-1, i= (a>=0)? m-1:0;
        while(l<=r){
            if(a>=0){
                ans[i--]=(helper(nums[l], a, b, c)>helper(nums[r], a, b, c))? helper(nums[l++], a, b, c):helper(nums[r--], a, b, c);
            }else{
                ans[i++]=(helper(nums[l], a, b, c)<helper(nums[r], a, b, c))? helper(nums[l++], a, b, c):helper(nums[r--], a, b, c);
            }
        }
        return ans;
    }
        
    private int helper(int x, int a, int b, int c){
        return x*x*a+x*b+c;
    }
    /*
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for(int i=0; i<nums.length; i++){
            nums[i]=(nums[i]*nums[i]*a)+(nums[i]*b)+c;
        }
        Arrays.sort(nums);
        return nums;
    }
    */
}