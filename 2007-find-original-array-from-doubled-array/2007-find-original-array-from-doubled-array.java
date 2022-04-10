class Solution {
    public int[] findOriginalArray(int[] changed) {
        int m=changed.length;
        if(m%2==1) return new int[0];
        
        Map<Integer, Integer> map=new TreeMap<>();
        for(int c:changed) map.put(c, map.getOrDefault(c, 0)+1);
        
        int i=0;
        int[] ans=new int[m/2];
        
        for(int k:map.keySet()){
            if(map.get(k)>map.getOrDefault(k+k, 0)) return new int[0];
            
            for(int j=0; j<map.get(k); j++){
                ans[i++]=k;
                map.put(k+k, map.get(k+k)-1);
            }
        }
        return ans;
    }
}