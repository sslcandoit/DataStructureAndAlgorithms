class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m=intervals.length;
        if(m==0 && newInterval.length==0 || intervals==null && newInterval==null) return intervals;
        
        List<int[]> list=new ArrayList<>();
        int x=newInterval[0];
        int y=newInterval[1];
        
        int i=0;
        while(i<m && intervals[i][1]<x){
            list.add(intervals[i]);
            i++;
        }
        
        while(i<m && intervals[i][0]<=y){
            x=Math.min(x, intervals[i][0]);
            y=Math.max(y, intervals[i][1]);
            i++;
        }
        
        list.add(new int[]{x, y});
        
        while(i<m){
            list.add(intervals[i++]);
        }
        
        int[][] ans=new int[list.size()][2];
        for(int j=0; j<list.size(); j++){
            ans[j]=list.get(j);
        }
        
        return ans;
    }
}