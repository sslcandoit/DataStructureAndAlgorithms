class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int countCandle[] = new int[s.length() + 1];
        int next[] = new int[s.length() + 1], prev[] = new int[s.length() + 1];
        Arrays.fill(next, Integer.MAX_VALUE);
        int res[] = new int[queries.length];
        for (int i = 0; i < s.length(); ++i) {//countCandle: [0,0,0,1,1,1,2,2,2,2,3]
            countCandle[i + 1] = countCandle[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];//prev: [0,0,0,2,2,2,5,5,5,5,9]
        }
        for (int i = s.length() - 1; i >= 0; --i){//next: [2,2,2,5,5,5,9,9,9,9,2147483647]
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        }
        for (int j = 0; j < queries.length; ++j) {
            int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
            res[j] = l < r ? r - l - (countCandle[r] - countCandle[l]) : 0;
        }        
        return res;
        /*
        int m=s.length(), n=queries.length, countCandle=0;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        for(int i=0; i<m; i++){
            if(s.charAt(i)=='|') map.put(i, countCandle++);
        }
        int[] ans=new int[n];
        for(int i=0; i<n; i++){
            Integer l=map.ceilingKey(queries[i][0]), r=map.floorKey(queries[i][1]);
            if(l==null || r==null || r<l) continue;
            ans[i]=r-l-(map.get(r)-map.get(l));
        }
        return ans;                                                                    */
    }
}

