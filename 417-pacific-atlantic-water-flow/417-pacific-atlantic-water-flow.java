class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        List<List<Integer>> ans=new ArrayList<>();
        if(heights==null || m==0 || n==0) return ans;
        boolean[][] pacific=new boolean[m][n], atlantic=new boolean[m][n];
        Queue<int[]> p=new LinkedList<>(), a=new LinkedList<>();
        for(int i=0; i<m; i++){
            pacific[i][0]=true;
            p.offer(new int[]{i,0});
            atlantic[i][n-1]=true;
            a.offer(new int[]{i, n-1});
        }
        for(int j=0; j<n; j++){
            pacific[0][j]=true;
            p.offer(new int[]{0, j});
            atlantic[m-1][j]=true;
            a.offer(new int[]{m-1, j});
        }
        bfs(heights, pacific, p);
        bfs(heights, atlantic, a);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]) ans.add(List.of(i,j));
            }
        }
        return ans;
    }
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    private void bfs(int[][] heights, boolean[][] reach, Queue<int[]> queue){
        int m=heights.length, n=heights[0].length;
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] dir:dirs){
                int x=dir[0]+cur[0], y=dir[1]+cur[1];
                if(x>=0 && x<m && y>=0 && y<n && !reach[x][y] && heights[x][y]>=heights[cur[0]][cur[1]]){
                    reach[x][y]=true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}