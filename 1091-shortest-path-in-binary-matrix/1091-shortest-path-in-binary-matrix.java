class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        if(grid[0][0]==1 || grid[m-1][m-1]==1) return -1;
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==m-1 && cur[1]==m-1) return cur[2];
            
            for(int[] dir:dirs){
                int x=dir[0]+cur[0];
                int y=dir[1]+cur[1];
                
                if(x>=0 && y>=0 && x<m && y<m && grid[x][y]==0){
                    grid[x][y]=1;
                    q.offer(new int[]{x, y, cur[2]+1});
                }
            }
        }
        return -1;
    }
}