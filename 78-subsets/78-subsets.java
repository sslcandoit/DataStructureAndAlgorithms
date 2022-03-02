class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> subset, int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        List<Integer> list=new ArrayList<>(subset);
        helper(nums, ans, subset, i+1);
        list.add(nums[i]);
        helper(nums, ans, list, i+1);
    }
}