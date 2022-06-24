class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        List<List<Integer>> list=new ArrayList<>();
        int m=nums.size(), count=0;
        
        for(int i=0; i<m; i++){
            int n=nums.get(i).size();
            count+=n;
            for(int j=0; j<n; j++){
                if(i+j==list.size()) list.add(new ArrayList<>());
                list.get(i+j).add(0, nums.get(i).get(j));
            }
        }
        int[] ans=new int[count];
        int k=0;
        for(int i=0; i<list.size(); i++){
            int j=0;
            while(j<list.get(i).size()) ans[k++]=list.get(i).get(j++);
        }
        return ans;
    }
}