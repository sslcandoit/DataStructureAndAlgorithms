class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[1]-b[1]);
        
        int ans=1, end=intervals[0][1];
       
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=end){
                ans++;
                end=intervals[i][1];
            } 
        }
        return intervals.length-ans;
    }
}
/*
 [  ]
  [   ]
[       ]
*/