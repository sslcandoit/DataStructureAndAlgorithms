class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=Arrays.stream(nums).sum();
        int[] dp=new int[total*2+1];
        dp[total+nums[0]]=1;
        dp[total-nums[0]]+=1;
        
        for(int i=1; i<nums.length; i++){
            int[] temp=new int[total*2+1];
            for(int sum=-total; sum<=total; sum++){
                if(dp[sum+total]>0){
                    temp[sum+total+nums[i]]+=dp[sum+total];
                    temp[sum+total-nums[i]]+=dp[sum+total];
                }
            }
            dp=temp;
        }
        return Math.abs(target)>total? 0:dp[target+total];
        /*
        Map<Integer, Integer> dp=new HashMap<>();
        dp.put(0,1);
        for(int num:nums){
            Map<Integer, Integer> temp=new HashMap<>();
            for(int curSum:dp.keySet()){
                int newSum1=curSum+num;
                temp.put(newSum1, temp.getOrDefault(newSum1, 0)+dp.get(curSum));
                int newSum2=curSum-num;
                temp.put(newSum2, temp.getOrDefault(newSum2, 0)+dp.get(curSum));
            }
            dp=temp;
        }
        return dp.getOrDefault(target,0);
        */
    }
}