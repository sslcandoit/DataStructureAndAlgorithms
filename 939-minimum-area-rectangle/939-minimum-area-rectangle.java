class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> set=new HashSet<>();
        for(int[] p:points) set.add(p[0]+"*"+p[1]);
        
        int min=Integer.MAX_VALUE;
        int n=points.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(points[i][0]==points[j][0] || points[i][1]==points[j][1]) continue;
                String s1=points[i][0]+"*"+points[j][1];
                String s2=points[j][0]+"*"+points[i][1];
                if(set.contains(s1) && set.contains(s2)){
                    int area=Math.abs((points[i][0]-points[j][0])*(points[i][1]-points[j][1]));
                    min=Math.min(min, area);
                }
            }
        }
        return min==Integer.MAX_VALUE? 0:min;
    }
}