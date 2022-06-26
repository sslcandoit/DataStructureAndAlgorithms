class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0; i+1<heights.length; i++){
            
            if(heights[i+1]>heights[i]) pq.offer(heights[i+1]-heights[i]);
            
            if(pq.size()>ladders) bricks-=pq.poll();
            
            if(bricks<0) return i;
        }
        return heights.length-1;
    }
}