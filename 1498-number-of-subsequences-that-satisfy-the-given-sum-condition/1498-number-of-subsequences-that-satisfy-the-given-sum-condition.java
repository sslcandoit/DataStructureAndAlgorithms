class Solution {
    public int numSubseq(int[] nums, int target) {
        int m=nums.length, l=0, r=m-1, sum=0, mod=(int)1e9+7;
        Arrays.sort(nums);
        
        int[] pows=new int[m];
        pows[0]=1;
        for(int i=1; i<m; i++) pows[i]=pows[i-1]*2%mod;
        
        while(l<=r){
            if(nums[l]+nums[r]>target) r--;
            else{
                sum=(sum+pows[r-l])%mod;
                l++;
            }
        }
        return sum;
    }
}
/*
[3,3,6,8]
[3,3,6,8],[3,3,6],[3,3,8],[3,6,8],[3,3],[3,8],[3,6],[3]
*/