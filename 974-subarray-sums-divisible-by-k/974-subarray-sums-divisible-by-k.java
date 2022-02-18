class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans=0;
        int[] count=new int[k];
        count[0]=1;
        int preRemainder=0;
        for(int num:nums){
            preRemainder=(preRemainder+(num%k+k))%k;
            ans+=count[preRemainder]++;
        }
        return ans;
    }
}