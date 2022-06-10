class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n=points.length;
        Map<String, List<int[]>> map=new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dis=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+
                        (points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                
                double cenX=(points[i][0]+points[j][0])/2.0, cenY=(points[i][1]+points[j][1])/2.0;
                
                String key=dis+"@"+cenX+"@"+cenY;
                if(!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }
        double ans=Double.MAX_VALUE;
        for(String key:map.keySet()){
            if(map.get(key).size()>=2){
                List<int[]> list=map.get(key);
                for(int i=0; i<list.size(); i++){
                    for(int j=i+1; j<list.size(); j++){
                        int p1=list.get(i)[0], p2=list.get(j)[0], p3=list.get(j)[1];
                        double side1=Math.sqrt((points[p1][0]-points[p2][0])*(points[p1][0]-points[p2][0])+
                                               (points[p1][1]-points[p2][1])*(points[p1][1]-points[p2][1]));
                        double side2=Math.sqrt((points[p1][0]-points[p3][0])*(points[p1][0]-points[p3][0])+
                                               (points[p1][1]-points[p3][1])*(points[p1][1]-points[p3][1]));
                        double area=side1*side2;
                        ans=Math.min(ans, area);
                    }
                }
            }
        }
        return ans==Double.MAX_VALUE? 0.0 : ans;
    }
}