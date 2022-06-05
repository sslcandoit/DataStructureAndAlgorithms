class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallest_Mdis=Integer.MAX_VALUE;
        List<Integer> index=new ArrayList<>();
        
        for(int i=0; i<points.length; i++){
            if(points[i][0]==x || points[i][1]==y){
                int manhattan_distance=Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                if(manhattan_distance<smallest_Mdis){
                    smallest_Mdis=manhattan_distance;
                    index.clear();
                    index.add(i);
                }else if(manhattan_distance==smallest_Mdis) index.add(i);
            }
        }
        return index.size()==0? -1:index.get(0);
    }
}