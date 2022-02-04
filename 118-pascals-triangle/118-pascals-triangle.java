class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int row=0; row<numRows; row++){
            List<Integer> sub=new ArrayList<>();
            sub.add(1);
            
            for(int j=1; j<row; j++){
                int sum=ans.get(row-1).get(j)+ans.get(row-1).get(j-1);
                sub.add(sum);
            }
            
            if(row !=0) sub.add(1);
            ans.add(sub);
        }
        return ans;
    }
}