class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        
        Arrays.sort(nums);
        int ans=1;
        int cur=1;
        for(int i=1; i<n; i++){
            if(nums[i] ==nums[i-1]) continue;
            
            if(nums[i-1]+1==nums[i]) cur++;
            else{
                ans=Math.max(ans, cur);
                cur=1;
            }
        }
        return Math.max(ans, cur);
    }
}