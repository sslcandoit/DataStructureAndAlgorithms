class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int[][] col=new int[m+1][n];
        int[][] row=new int[m][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                col[i+1][j]=grid[i][j]+col[i][j];
                row[i][j+1]=grid[i][j]+row[i][j];
            }
        }
        int maxSide=Math.max(m, n);
        for(int s=maxSide; s>=1; s--){
            for(int i=0; i<=m-s; i++){
                for(int j=0; j<=n-s; j++){
                    if(magic(grid, col, row, i, j, s)) return s;
                }
            }
        }
        return 1;
    }
    private boolean magic(int[][] grid, int[][] col, int[][] row, int i, int j, int side){
        int sum=row[i][j+side]-row[i][j];
        int dia=0, anti_dia=0;
        for(int k=0; k<side; k++){
            dia+=grid[i+k][j+k];
            anti_dia+=grid[i+side-1-k][j+k];
            if(row[i+k][j+side]-row[i+k][j] !=sum || col[i+side][j+k]-col[i][j+k] !=sum) return false;
        }
        return dia==sum && anti_dia==sum;
    }
}