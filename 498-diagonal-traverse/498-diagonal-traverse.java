class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[] res=new int[m*n];
        int index=0;
        
        int i, j;
        for(int k=0; k<m+n-1; k++){
            if(k%2==0){
                i= k<m? k:m-1;
                j= k<m? 0:k-(m-1);
                while(i>=0 && j<n) res[index++]=mat[i--][j++];
            }else{
                i= k<n? 0:k-(n-1);
                j= k<n? k:n-1;
                while(i<m && j>=0) res[index++]=mat[i++][j--];
            }
        }
        return res;
    }
}