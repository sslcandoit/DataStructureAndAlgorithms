class Solution {
    public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        
        long total=0, ans=-1;
        int minEven=-1, minOdd=-1, maxEven=-1, maxOdd=-1, n=nums.length;
        for(int i=n-1; i>=n-k; i--){
            total+=nums[i];
            if(nums[i]%2==0) minEven=nums[i];
            else minOdd=nums[i];
        }
        if(total%2==0) return total;
        
        for(int i=0; i<n-k; i++){
            if(nums[i]%2==0) maxEven=nums[i];
            else maxOdd=nums[i];
        }
        if(minOdd !=-1 && maxEven !=-1) ans=Math.max(ans, total-minOdd+maxEven);
        if(minEven !=-1 && maxOdd !=-1) ans=Math.max(ans, total-minEven+maxOdd);
        return ans;
    }
}