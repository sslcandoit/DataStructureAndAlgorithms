class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }
    private void helper(List<List<Integer>> ans, List<Integer> temp, int n, int k, int start){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++){
            temp.add(i);
            helper(ans, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}