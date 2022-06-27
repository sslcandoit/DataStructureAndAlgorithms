class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        int m=intervals.length;
        for(int i=1; i<m; i++){
            int l=Math.max(intervals[i-1][0], intervals[i][0]);
            int r=Math.min(intervals[i-1][1], intervals[i][1]);
            if(l<r) return false;
        }
        return true;
    } 
                                                                                         /*
    true:
    [   ][    ] 
    
    false:
    [    ]
      [     ]
                                                                                          */
}