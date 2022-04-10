class Solution {
    public int longestArithSeqLength(int[] nums) {
        int m=nums.length;
        Map<Integer, Integer>[] dp=new HashMap[m];
        
        int ans=2;
        for(int i=0; i<m; i++){
            dp[i]=new HashMap<>();
            for(int j=0; j<i; j++){
                int diff=nums[i]-nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1)+1);
                ans=Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}
//dp: [{},{-5:2},{-2:2,3:2},{-2:2,-5:2,-7:2},{1:2,3:3,6:2,8:2}]


