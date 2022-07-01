class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans=new ArrayList<>();
        
        
        int i=0, j=0;
        while(i<encoded1.length && j<encoded2.length){
            int min=Math.min(encoded1[i][1], encoded2[j][1]);
            
            ArrayList<Integer> temp=new ArrayList<>();
            int product=encoded1[i][0]*encoded2[j][0];
            
            if(ans.size()>0 && product==ans.get(ans.size()-1).get(0)){
                ans.get(ans.size()-1).set(1, ans.get(ans.size()-1).get(1)+min);
            }else{
                temp.add(product);
                temp.add(min);
                ans.add(temp);
            }
    
            encoded1[i][1]-=min;
            encoded2[j][1]-=min;
            
            if(encoded1[i][1]==0) i++;
            if(encoded2[j][1]==0) j++;
        }
        return ans;
    }
}