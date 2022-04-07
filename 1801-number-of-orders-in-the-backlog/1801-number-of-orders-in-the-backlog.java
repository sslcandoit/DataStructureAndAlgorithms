class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<int[]> buy=new PriorityQueue<>((a,b)->b[0]-a[0]);
        
        for(int[] o:orders){
            if(o[2]==0) buy.offer(o);
            else sell.offer(o);
            
            while(!sell.isEmpty() && !buy.isEmpty() && buy.peek()[0]>=sell.peek()[0]){
                int quantity=Math.min(buy.peek()[1], sell.peek()[1]);
                buy.peek()[1]-=quantity;
                sell.peek()[1]-=quantity;
                if(buy.peek()[1]==0) buy.poll();
                if(sell.peek()[1]==0) sell.poll();
            }
        }
        int ans=0, mod=1000000007;
        while(!sell.isEmpty()) ans=(ans+sell.poll()[1])%mod;
        while(!buy.isEmpty()) ans=(ans+buy.poll()[1])%mod;
        return ans;
    }
}