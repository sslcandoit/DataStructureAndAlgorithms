class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m=maze.length, n=maze[0].length;
        Set<Integer> visited=new HashSet<>();
        Queue<int[]> q=new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            visited.add(cur[0]*n+cur[1]);
            if(cur[0]==destination[0] && cur[1]==destination[1]) return true;
            
            for(int[] d:dirs){
                int x=cur[0], y=cur[1];
                
                while(x+d[0]>=0 && x+d[0]<m && y+d[1]>=0 && y+d[1]<n && maze[x+d[0]][y+d[1]]==0){
                    x+=d[0];
                    y+=d[1];
                }
                if(!visited.contains(x*n+y)) q.add(new int[]{x, y});
            }
        }
        return false;
    }
}