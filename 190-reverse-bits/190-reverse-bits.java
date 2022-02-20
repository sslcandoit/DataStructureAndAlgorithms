public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==0) return n;
        
        int ans=0;
        for(int i=0; i<32; i++){
            ans=(ans<<1)|(n&1);
            n>>=1;
        }
        return ans;
    }
}