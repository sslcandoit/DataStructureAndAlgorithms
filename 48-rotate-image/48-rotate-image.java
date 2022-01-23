class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        int top=0, down=m-1;
        while(top<down){
            int[] temp=matrix[top];
            matrix[top]=matrix[down];
            matrix[down]=temp;
            top++;
            down--;
        }
        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}