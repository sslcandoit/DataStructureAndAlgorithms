class Solution {
    public int shortestBridge(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> queue=new LinkedList<>();
        int step=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    dfs(grid, i, j, queue);
                    while(!queue.isEmpty()){
                        int size=queue.size();
                        for(int s=0; s<size; s++){
                            int[] cur=queue.poll();
                            for(int[] dir:dirs){
                                int x=dir[0]+cur[0];
                                int y=dir[1]+cur[1];
                                if(x>=0 && y>=0 && x<m && y<n){
                                    if(grid[x][y]==1) return step;
                                    else if(grid[x][y]==0){
                                        grid[x][y]=2;
                                        queue.offer(new int[]{x, y});
                                    }
                                }
                            }   
                        }
                        step++;
                    }
                } 
            }    
        }
        return step;
    }
    private void dfs(int[][] grid, int i, int j, Deque<int[]> queue){
        if(grid[i][j] !=1) return;
        
        grid[i][j]=2;
        queue.offer(new int[]{i, j});
        if(i+1<grid.length) dfs(grid, i+1, j, queue);
        if(i-1>=0) dfs(grid, i-1, j, queue);
        if(j+1<grid[0].length) dfs(grid, i, j+1, queue);
        if(j-1>=0) dfs(grid, i, j-1, queue);
    }
}