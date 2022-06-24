class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
         int len = 0; // count length of result array
        // reorder list<list<Int>> by Diagonal index(i+j) with reverse order;
        List<List<Integer>> list = new ArrayList<>(); 
        for (int i = 0; i < nums.size(); i++){
            len += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++){
                int idx = i+j;
                if (idx >= list.size()) list.add(new ArrayList<>());
                list.get(idx).add(0, nums.get(i).get(j));
            }
        } 
        int[] res = new int[len];
        int k = 0;
        for (int i = 0; i < list.size(); i++)
            for (int j = 0; j < list.get(i).size(); j++)
                res[k++] = list.get(i).get(j);
        return res;
        /*
        List<List<Integer>> list=new LinkedList<>();
        int m=nums.size(), count=0;
        
        for(int i=0; i<m; i++){
            int n=nums.get(i).size();
            count+=n;
            for(int j=0; j<n; j++){
                if(i+j==list.size()) list.add(new LinkedList<>());
                list.get(i+j).add(0, nums.get(i).get(j));
            }
        }
        int[] ans=new int[count];
        int k=0;
        for(int i=0; i<list.size(); i++){
            int j=0;
            while(j<list.get(i).size()) ans[k++]=list.get(i).get(j++);
        }
        return ans;*/
    }
}