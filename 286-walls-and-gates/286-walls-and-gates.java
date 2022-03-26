class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m=rooms.length, n=rooms[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0) q.offer(new int[]{i, j, 0});
            }
        }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] dir:dirs){
                int x=cur[0]+dir[0];
                int y=cur[1]+dir[1];
                if(x>=0 && y>=0 && x<m && y<n && rooms[x][y] !=-1 && rooms[x][y] !=0){
                    if((rooms[x][y]>0 && rooms[x][y]>cur[2]+1) || rooms[x][y]<0){
                        rooms[x][y]=cur[2]+1;
                        q.offer(new int[]{x, y, rooms[x][y]});
                    } 
                }
            }
        }
    return;
    }
}