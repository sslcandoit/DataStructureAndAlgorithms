class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m1=mat1.length, n1=mat1[0].length, m2=n1, n2=mat2[0].length;
        
        int[][] ans=new int[m1][n2];
        for(int i=0; i<m1; i++){
            for(int j=0; j<n1; j++){
                if(mat1[i][j] !=0){
                    for(int jj=0; jj<n2; jj++){
                        if(mat2[j][jj] !=0) ans[i][jj]+=mat1[i][j]*mat2[j][jj];
                    }
                }
            }
        }
        return ans;
    }
}