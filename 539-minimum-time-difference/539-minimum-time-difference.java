class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            String t=timePoints.get(i);
            int h=Integer.parseInt(t.substring(0,2));
            int m=Integer.parseInt(t.substring(3));
            
            list.add(h*60+m);
        }
        Collections.sort(list);
        int ans=Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            ans=Math.min(ans, list.get(i)-list.get(i-1));
        }
        int corner=list.get(0)+(24*60-list.get(n-1));
        return Math.min(corner, ans);
    }
    /*
    13:10 14:20
          14:05
          13:20
         */
}