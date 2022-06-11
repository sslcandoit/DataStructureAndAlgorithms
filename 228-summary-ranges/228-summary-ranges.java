class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        int n=nums.length;
        if(n==1){
            ans.add(""+nums[0]);
            return ans;
        }
        for(int i=0; i<n; i++){
            int start=nums[i];
            while(i+1<n && nums[i+1]==nums[i]+1) i++;
            
            if(nums[i]==start) ans.add(""+start);
            else ans.add(start+"->"+nums[i]);
        }  
        return ans;
    }
}