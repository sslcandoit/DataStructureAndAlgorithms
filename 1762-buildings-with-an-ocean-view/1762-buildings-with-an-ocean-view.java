class Solution {
    public int[] findBuildings(int[] heights) {
        int max=0;
        List<Integer> list=new ArrayList<>();
        for(int i=heights.length-1; i>=0; i--){
            if(heights[i]>max){
                list.add(0, i);
                max=heights[i];
            } 
        }
        int[] ans=new int[list.size()];
        for(int i=0; i<list.size(); i++) ans[i]=list.get(i);
        return ans;
    }
}