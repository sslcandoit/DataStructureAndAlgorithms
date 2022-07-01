class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> map=new TreeMap<>();
        int m=s.length(), n=queries.length, countCandle=0;
        
        for(int i=0; i<m; i++){
            char c=s.charAt(i);
            if(c=='|') map.put(i, countCandle++);
        }
        int[] ans=new int[n];
        
        for(int i=0; i<n; i++){
            int[] q=queries[i];
            
            Integer l=map.ceilingKey(q[0]);
            Integer r=map.floorKey(q[1]);
            
            if(l==null || r==null || r<l) continue;
            ans[i]=r-l-(map.get(r)-map.get(l));
        }
        return ans;
    }
}