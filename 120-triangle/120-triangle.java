class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        for(int i=m-2; i>=0; i--){
            List<Integer> top=triangle.get(i);
            List<Integer> bottom=triangle.get(i+1);
            for(int j=0; j<i+1; j++){
                top.set(j, top.get(j)+Math.min(bottom.get(j), bottom.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}