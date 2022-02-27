class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int a:arr){
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        if(k==0) return map.size();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));
        for(int key:map.keySet()) pq.add(key);
        
        while(k>0){
            int cur=pq.poll();
            int freq=map.get(cur);
            if(freq==k) return pq.size();
            else if(freq<k) k-=freq;
            else return pq.size()+1;
        }
        return -1;
    }
}