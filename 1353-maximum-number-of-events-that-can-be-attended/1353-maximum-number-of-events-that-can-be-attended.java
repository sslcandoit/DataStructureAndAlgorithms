class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int ans=0;
        int i=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int days=1; days<=100000; days++){
            while(!pq.isEmpty() && pq.peek()<days) pq.poll();
            
            while(i<events.length && events[i][0]==days) pq.add(events[i++][1]);
            
            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
        } 
        return ans;
    }
    /*
    [[1,5],[1,5],[1,5],[2,3],[2,3]]
    [[1,2],[1,2],[3,3],[1,5],[1,5]]
    [[1,4],[4,4],[2,2],[3,4],[1,1]]
    [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
    */
}