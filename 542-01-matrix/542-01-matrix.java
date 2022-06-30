class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) q.offer(i*n+j);
                else mat[i][j]=-1;
            }
        }
        int[][] dirs={{0, 1}, {0, -1},{1, 0},{-1, 0}};
        while(!q.isEmpty()){
            int cur=q.poll();
            int i=cur/n, j=cur%n;
            
            for(int[] d:dirs){
                int x=i+d[0], y=j+d[1];
                if(x>=0 && y>=0 && x<m && y<n && mat[x][y]==-1){
                    mat[x][y]=mat[i][j]+1;
                    q.offer(x*n+y);
                }
            }
        }
        return mat;
    }
}