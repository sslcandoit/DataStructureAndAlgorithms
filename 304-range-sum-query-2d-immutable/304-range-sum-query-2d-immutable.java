class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        this.sum=new int[m+1][n+1];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum[i+1][j+1]=sum[i][j+1]+sum[i+1][j]+matrix[i][j]-sum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sum[row2+1][col2+1]-this.sum[row1][col2+1]-this.sum[row2+1][col1]+this.sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */