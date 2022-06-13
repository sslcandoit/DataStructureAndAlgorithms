class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1; i<=n; i++) q.add(i);
        
        while(q.size()>1){
            int delete=k-1;
            while(delete>0){
                q.add(q.poll());
                delete--;
            }
            q.poll();
        }
        return q.poll();
    }
}