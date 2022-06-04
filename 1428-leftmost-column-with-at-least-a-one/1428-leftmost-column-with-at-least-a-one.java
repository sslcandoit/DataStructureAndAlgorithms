/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list=binaryMatrix.dimensions();
        int m=list.get(0), n=list.get(1);
        
        int row=0, col=n-1, ans=-1;
        while(row<m && col>=0){
            if(binaryMatrix.get(row, col)==1){
                ans=col;
                col--;
            }else row++;
        }
        return ans;
    }
    /*
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list=binaryMatrix.dimensions();
        int m=list.get(0), n=list.get(1);
        
        int left=0, right=n, ans=-1;
        for(int row=0; row<m; row++){
            while(left<right){
                int mid=left+(right-left)/2;
                if(helper(binaryMatrix, m, mid)){
                    right=mid;
                    ans=mid;
                }else left=mid+1;
            }
        }
        return ans;
    }
    private boolean helper(BinaryMatrix bM, int m, int mid){
        for(int i=0; i<m; i++){
            if(bM.get(i, mid)==1) return true;
        }
        return false;
    }
    */
}