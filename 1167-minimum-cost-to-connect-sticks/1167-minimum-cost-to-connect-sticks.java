class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length==1) return 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> a-b);
        for(int s:sticks) pq.add(s);
        int cost=0;
        while(pq.size()>=2){
            int a=pq.poll(), b=pq.poll();
            pq.add(a+b);
            cost+=a+b;
        }
        return cost;
    }
}