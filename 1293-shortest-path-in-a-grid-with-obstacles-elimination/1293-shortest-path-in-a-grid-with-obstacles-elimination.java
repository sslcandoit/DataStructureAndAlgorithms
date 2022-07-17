class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        boolean[][][] visited=new boolean[m][n][k+1];
        
        q.offer(new int[]{0, 0, k});
        visited[0][0][k]=true;
        
        int[][] dirs={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0; i<size; i++){
                int[] cur=q.poll();
                
                if(cur[0]==m-1 && cur[1]==n-1) return ans;
                
                for(int[] d:dirs){
                    int x=d[0]+cur[0];
                    int y=d[1]+cur[1];
                    int curK=cur[2];
                    
                    if(x>=0 && x<m && y>=0 && y<n){
                        if(grid[x][y]==1) curK--;
                        
                        if(curK>=0 && !visited[x][y][curK]){
                            visited[x][y][curK]=true;
                        
                            q.offer(new int[]{x, y, curK});
                        };
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
/*
[0,0,0,0,0,0,0,0,0,0],
[0,1,1,1,1,1,1,1,1,0],
[0,1,0,0,0,0,0,0,0,0],
[0,1,0,1,1,1,1,1,1,1],
[0,1,0,0,0,0,0,0,0,0],
[0,1,1,1,1,1,1,1,1,0],
[0,1,0,0,0,0,0,0,0,0],
[0,1,0,1,1,1,1,1,1,1],
[0,1,0,1,1,1,1,0,0,0],
[0,1,0,0,0,0,0,0,1,0],
[0,1,1,1,1,1,1,0,1,0],
[0,0,0,0,0,0,0,0,1,0]
1
*/