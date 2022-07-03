class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        
        helper(ans, new ArrayList<>(), k, n, 0, 1);
        return ans;
    }
    private void helper(List<List<Integer>> ans, List<Integer> temp, int k, int n, int sum, int index){
        if(temp.size()==k){
            if(sum==n) ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index; i<=9; i++){
            if(sum+i>n) break;
            temp.add(i);
            helper(ans, temp, k, n, sum+i, i+1);
            temp.remove(temp.size()-1);
        }
    }   
}