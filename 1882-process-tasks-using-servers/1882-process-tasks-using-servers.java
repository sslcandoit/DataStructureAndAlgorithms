class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServers=new PriorityQueue<>((a,b)-> a[0] != b[0]? a[0]-b[0]:a[1]-b[1]);
        for(int i=0; i<servers.length; i++) freeServers.offer(new int[]{servers[i], i, 0});

        PriorityQueue<int[]> processing=
            new PriorityQueue<>((a,b)-> a[2] != b[2]? a[2]-b[2]: (a[0] !=b[0]? a[0]-b[0] : a[1]-b[1]));
        
        int[] ans=new int[tasks.length];
        
        for(int i=0; i<tasks.length; i++){
            while(!processing.isEmpty() && processing.peek()[2]==i) freeServers.offer(processing.poll());
            
            if(!freeServers.isEmpty()){
                int[] cur=freeServers.poll();
                ans[i]=cur[1];
                processing.offer(new int[]{cur[0] ,cur[1], i+tasks[i]});
            }else{
                int[] cur=processing.poll();
                ans[i]=cur[1];
                processing.offer(new int[]{cur[0], cur[1], cur[2]+tasks[i]});
            }
        }
        return ans;
    }
}