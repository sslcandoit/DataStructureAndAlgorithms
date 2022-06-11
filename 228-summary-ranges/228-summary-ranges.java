class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        int n=nums.length;
        if(n==0) return ans;
        
        int start=nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1]+1) continue;
            
            if(nums[i-1]==start) ans.add(""+start);
            else ans.add(start+"->"+nums[i-1]);
            
            start=nums[i];
        }
        if(nums[n-1]==start) ans.add(""+start);
        else ans.add(start+"->"+nums[n-1]);
        
        return ans;
    }
}