class Solution {
    public int findTargetSumWays(int[] nums, int target) {
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
    }
}