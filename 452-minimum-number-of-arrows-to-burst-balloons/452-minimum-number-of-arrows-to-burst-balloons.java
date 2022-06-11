class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0]));
        int ans=1;
        int[] cur=points[0];
        for(int i=1; i<points.length; i++){
            if(points[i][0]>cur[1]){
                ans++;
                cur=points[i];
            }else{
                cur[0]=Math.max(cur[0], points[i][0]);
                cur[1]=Math.min(cur[1], points[i][1]);
            }
        }
        return ans;
    }
}