class Solution {
    public int waysToSplit(int[] nums) {
        int size=nums.length;
        
        for(int i=1; i<size; i++) nums[i]+=nums[i-1];
        
        int ans=0;
        for(int i=0, j=0, k=0; i<size-2; i++){
            while(j<=i || (j<size-1 && nums[j]-nums[i]<nums[i])) j++;
            
            while(k<j || (k<size-1 && nums[k]-nums[i]<=nums[size-1]-nums[k])) k++;
            
            ans=(ans+k-j)%1000000007;
        }
        return ans;
    }
}