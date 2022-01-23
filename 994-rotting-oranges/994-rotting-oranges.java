class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        
        int count_fresh=0;
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2) q.offer(new int[]{i, j});
                else if(grid[i][j]==1) count_fresh++;
            }
        }
        if(count_fresh==0) return 0;
        int minutes=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int[] origin=q.poll();
                for(int[] dir:dirs){
                    int x=dir[0]+origin[0];
                    int y=dir[1]+origin[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        q.offer(new int[]{x, y});
                        grid[x][y]=2;
                        count_fresh--;
                    }
                }
            }
            minutes++;
        }
        return count_fresh==0? minutes-1:-1;
    }
}