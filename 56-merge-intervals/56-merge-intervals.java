class Solution {
    public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        if(m==1) return intervals;
        
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
       
        List<int[]> list=new ArrayList<>();
        int[] cur=intervals[0];
        for(int i=1; i<m; i++){
            if(intervals[i][0]>cur[1]){
                list.add(cur);
                cur=intervals[i];
            }else cur[1]=Math.max(cur[1], intervals[i][1]);
        }
        list.add(cur);
        return list.toArray(new int[list.size()][2]);
        
    }
}