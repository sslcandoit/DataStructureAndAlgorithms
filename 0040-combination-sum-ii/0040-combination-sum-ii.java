class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, 0, new ArrayList<>());
        return ans;
    }
    
    private void helper(int[] nums, int remain, List<List<Integer>> ans, int index, List<Integer> temp){
        if(remain==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index==nums.length) return;
        
        for(int i=index; i<nums.length; i++){
            int num=nums[i];
            if(num>remain) break;
            
            if(i !=index && nums[i]==nums[i-1]) continue;
            
            temp.add(num);
            helper(nums, remain-num, ans, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}