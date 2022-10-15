class Solution {
    public List<Integer> grayCode(int n) {
        int last=(1<<n)-1;
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0; i<=last; i++){
            ans.add(i^(i/2));
        }
        return ans;
    }
}