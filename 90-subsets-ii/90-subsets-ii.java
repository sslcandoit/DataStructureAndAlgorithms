class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> subset, int i){
        ans.add(new ArrayList<>(subset));
        
        for(int j=i; j<nums.length; j++){
            if(j>i && nums[j]==nums[j-1]) continue;
            subset.add(nums[j]);
            helper(nums, ans, subset, j+1);
            subset.remove(subset.size()-1);
        }
        /*
        if(i==nums.length){
            List<Integer> temp=new ArrayList<>(subset);
            if(!ans.contains(temp)) ans.add(temp);
            return;
        }
        List<Integer> list=new ArrayList<>(subset);
        helper(nums, ans, subset, i+1);
        list.add(nums[i]);
        helper(nums, ans, list, i+1);
        */
    }
}