class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n=words.length;
        
        Map<String, Integer> map=new HashMap<>();
        for(String w:words) map.put(w, map.getOrDefault(w, 0)+1);
        
        PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if(e1.getValue() !=e2.getValue()) return e1.getValue()-e2.getValue();
                return e2.getKey().compareTo(e1.getKey());
            }
        });
        for(Map.Entry<String, Integer> e:map.entrySet()){
            pq.add(e);
            if(pq.size()>k) pq.poll();
        }
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty()) ans.add(0, pq.poll().getKey());
        
        return ans;
    }
}