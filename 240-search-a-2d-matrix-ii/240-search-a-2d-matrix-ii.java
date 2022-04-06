class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        if(matrix==null || m==0 || n==0) return false;
        
        int row=0, col=n-1;
        while(row<m && col>=0){
            int num=matrix[row][col];
            if(num==target) return true;
            else if(num>target) col--;
            else if(num<target) row++;
        }
        return false;
    }
}