class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] !=b[0]? a[0]-b[0] : b[1]-a[1]);
        
        int ans=0, right=0;
        for(int[] v:intervals){
            if(v[1]>right){
                ans++;
                right=v[1];
            }
        }
        return ans;
    }
}
/*

[              ]
[            ]
 [      ]
  [              ]
   [               ]
   
*/