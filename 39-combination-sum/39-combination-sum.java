class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp=new List[target+1];
        for(int i=0;i<dp.length; i++) dp[i]=new ArrayList<>();
        dp[0].add(new ArrayList<>());
        
        for(int c:candidates){
            for(int j=c; j<=target; j++){
                for(List<Integer> temp: dp[j-c]){
                    List<Integer> newTemp=new ArrayList<>(temp);
                    newTemp.add(c);
                    dp[j].add(newTemp);
                }
            }
        }
        return dp[target];
    }
    /*
    private List<List<Integer>> ans;
    private int[] nums;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans=new ArrayList<>();
        this.nums=candidates;
        helper(new ArrayList<>(), target, 0);
        return ans;
    }
    private void helper(List<Integer> list, int target, int index){
        if(target<0) return;
        if(target==0){
            this.ans.add(new ArrayList<>(list));
            return;
        } 
        for(int i=index; i<this.nums.length; i++){
            list.add(nums[i]);
            helper(list, target-nums[i], i);
            list.remove(list.size()-1);
        }
    }
    */
}