class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)-> a[1]-b[1]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)-> a[1]-b[1]);
        
        for(int[] t:trips){
            int numPassengers=t[0];
            int from=t[1];
            int to=t[2];
            
            while(!pq.isEmpty() && pq.peek()[1] <= from){
                int[] temp=pq.poll();
                capacity+=temp[0];
            }
            capacity-=numPassengers;
            if(capacity<0) return false;
            pq.add(new int[]{numPassengers, to});
        }
        return true;
    }
}