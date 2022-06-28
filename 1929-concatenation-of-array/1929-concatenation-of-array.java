class Solution {
    public int[] getConcatenation(int[] nums) {
        int m=nums.length;
        int[] ans=new int[m+m];
        for(int i=0; i<m; i++){
            ans[i]=nums[i];
            ans[i+m]=nums[i];
        }
        return ans;
    }
}