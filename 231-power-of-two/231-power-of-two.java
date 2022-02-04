class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        if(n==1) return true;
        
        return (n&(n-1))==0;
    }
}