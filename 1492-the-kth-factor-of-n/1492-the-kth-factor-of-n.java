class Solution {
    public int kthFactor(int n, int k) {
        int sqrtn=(int)Math.sqrt(n);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=1; i<=sqrtn; i++){
            if(n%i==0){
                pq.offer(i);
                if(i*i !=n) pq.offer(n/i);
            } 
            while(pq.size()>k) pq.poll();
        }
        return pq.size()==k? pq.poll():-1;
    }
}