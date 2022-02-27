class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        for(int s:stones) pq.add(s);
        while(pq.size()>=2){
            int big=pq.poll();
            int small=pq.poll();
            if(big==small) continue;
            else pq.offer(big-small);
        }
        return pq.size()==0? 0:pq.poll();
    }
}