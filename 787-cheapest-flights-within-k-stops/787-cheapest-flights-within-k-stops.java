class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph=new int[n][n];
        for(int[] f:flights) graph[f[0]][f[1]]=f[2];
        
        int[] cost=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src, 0, k+1});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int place=cur[0], price=cur[1], remainStops=cur[2];
            if(remainStops>0){
                for(int i=0; i<n; i++){
                    int spend=graph[place][i];
                    if(spend>0 && spend+price<cost[i]){
                        cost[i]=spend+price;
                        q.offer(new int[]{i, cost[i], remainStops-1});
                    }
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE? -1:cost[dst];
    }
}