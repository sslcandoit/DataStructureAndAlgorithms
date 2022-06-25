class Solution {
    public int getFood(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='*'){
                    q.add(i*n+j);
                    grid[i][j]='X';
                    break;
                } 
            }
            if(!q.isEmpty()) break;
        }
        
        int[][] dirs={{0, 1}, {0,-1}, {1,0},{-1,0}};
        int len=0;
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int k=0; k<size; k++){
                int cur=q.poll();
                int i=cur/n, j=cur%n;
                
                for(int[] d:dirs){
                    int x=i+d[0];
                    int y=j+d[1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y] !='X'){
                        if(grid[x][y]=='#') return len+1;
                        grid[x][y]='X';
                        q.add(x*n+y);
                    }
                }
            }
            len++;
        }
        return -1;
    }
}