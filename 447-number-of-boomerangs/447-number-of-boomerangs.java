class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map=new HashMap<>();
        int m=points.length, ans=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(i==j) continue;
                
                int x=(points[i][0]-points[j][0])*(points[i][0]-points[j][0]);
                int y=(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                int dis=x+y;
                
                map.put(dis, map.getOrDefault(dis, 0)+1);
            }
            for(int v:map.values()) ans+=v*(v-1);
            map.clear();
        }
        return ans;
    }
}