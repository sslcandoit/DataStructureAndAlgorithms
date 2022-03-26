class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        List<Integer>[] dp=new List[len];
        
        List<Integer> ans=new ArrayList<>();
        //[1,2,4,6,8]
        for(int i=0; i<len; i++){
            if(dp[i]==null) dp[i]=new ArrayList<>();
            dp[i].add(nums[i]);
            
            List<Integer> temp=new ArrayList<>();
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0 && dp[j].size()>temp.size()) temp=dp[j];
            }
            dp[i].addAll(temp);
            if(dp[i].size()>ans.size()) ans=dp[i];
        }
        return ans;
    }
}