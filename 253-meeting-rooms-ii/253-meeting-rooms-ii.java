class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int ans=0;
        for(int[] i:intervals){
            if(pq.isEmpty() || (!pq.isEmpty() && pq.peek()>i[0])){
                pq.offer(i[1]);
                ans++;
            }else{
                pq.poll();
                pq.offer(i[1]);
            }
        }
        return ans;
    }
}