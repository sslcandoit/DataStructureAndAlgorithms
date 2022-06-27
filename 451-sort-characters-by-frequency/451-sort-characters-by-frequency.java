class Solution {
    public String frequencySort(String s) {
        int m=s.length();
        
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<m; i++){
            String ss=s.substring(i, i+1);
            map.put(ss, map.getOrDefault(ss, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<>((a, b)-> b.getValue()-a.getValue());
        
        for(Map.Entry<String, Integer> e:map.entrySet()) pq.offer(e);
        
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<String, Integer> cur=pq.poll();
            String key=cur.getKey();
            key=key.repeat(cur.getValue());
            sb.append(key);
        }
        return sb.toString();
    }
}