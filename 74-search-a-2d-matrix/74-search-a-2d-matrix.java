class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        if(m==0 || (m==1 && n==1 && matrix[0][0] !=target)) return false;
        if(m==1 && n==1 && matrix[0][0] ==target) return true;
        
        int l=0, r=m*n;
        while(l<r){
            int mid=l+(r-l)/2;
            int num=matrix[mid/n][mid%n];
            if(num==target) return true;
            else if(num>target) r=mid;
            else l=mid+1;
        }
        return false;
    }
}