class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums, ans, new boolean[nums.length], new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums, List<List<Integer>> ans, boolean[] added, List<Integer> temp){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!added[i]){
                if(i>0 && nums[i]==nums[i-1] && !added[i-1]) continue;
                temp.add(nums[i]);
                added[i]=true;
                helper(nums, ans, added, temp);
                temp.remove(temp.size()-1);
                added[i]=false;
            }
        }
    }
}