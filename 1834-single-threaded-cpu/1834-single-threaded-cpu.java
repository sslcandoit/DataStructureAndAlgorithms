class Solution {
    public int[] getOrder(int[][] tasks) {
        int m=tasks.length;
        
        int[][] temp=new int[m][3];
        for(int i=0; i<m; i++){
            temp[i][0]=tasks[i][0];
            temp[i][1]=tasks[i][1];
            temp[i][2]=i;
        }
        Arrays.sort(temp, (a,b)->a[0]-b[0]);
        
        PriorityQueue<int[]> waiting=new PriorityQueue<>((a,b)->a[1]==b[1]? a[2]-b[2]:a[1]-b[1]);
        
        int[] ans=new int[m];
        int j=0;
        
        int i=0, time=0;
        while(j<m){
            while(i<m && temp[i][0]<=time) waiting.offer(temp[i++]);

             if(waiting.isEmpty()) {
                time=temp[i][0];
                continue;
            }
            int[] cur=waiting.poll();
            ans[j++] = cur[2];
            time+=cur[1];
        }    
        return ans;
    }
    //   0       1       2       3      4       5       6.    7       8       9       10    11      12      13
    //[[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]
    //[6,1,2,9,4,10,0,11,5,13,3,8,12,7]
}