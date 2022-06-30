class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length, maxDis=m+n;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0) continue;
                int left=maxDis, top=maxDis;
                if(i-1>=0) top=mat[i-1][j];
                if(j-1>=0) left=mat[i][j-1];
                mat[i][j]=Math.min(top, left)+1;
            }
        }
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(mat[i][j]==0) continue;
                if(i+1<m) mat[i][j]=Math.min(mat[i][j], mat[i+1][j]+1);
                if(j+1<n) mat[i][j]=Math.min(mat[i][j], mat[i][j+1]+1);
            }
        }
        return mat;
            
        /*
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
        return mat;*/
    }
}