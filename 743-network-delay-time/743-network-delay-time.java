class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map=new HashMap<>();
        for(int[] t:times){
            if(!map.containsKey(t[0])) map.put(t[0], new HashMap<>());
            map.get(t[0]).put(t[1], t[2]);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->  a[1]-b[1]);
        pq.add(new int[]{k, 0});
        
        int ans=0;
        
        boolean[] visited=new boolean[n+1];
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            
            if(visited[cur[0]]) continue;
            
            visited[cur[0]]=true;
            n--;
            ans=cur[1];
            
            Map<Integer, Integer> neb=map.get(cur[0]);
            if(neb !=null){
                for(Integer to: neb.keySet()){
                    if(!visited[to]) pq.add(new int[]{to, cur[1]+neb.get(to)});
                }
            }
        }
        return n==0? ans:-1;
    }
}