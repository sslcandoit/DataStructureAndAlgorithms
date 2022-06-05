class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        long lower=Integer.MIN_VALUE;
        long upper=Integer.MAX_VALUE;
        
        while(lower<upper){
            long mid=lower+(upper-lower)/2;
            int count=count_smallerEqualThanMid(matrix, mid);
            if(count<k) lower=mid+1;
            else upper=mid;
        }
        return (int)lower;
    }
    private int count_smallerEqualThanMid(int[][] matrix, long mid){
        int count=0;
        int n=matrix.length;
        int i=n-1, j=0;
        while(i>=0 && j<n){
            if(matrix[i][j]<=mid){
                count+=(i+1);
                j++;
            }else i--;
        }
        return count;
    }
}