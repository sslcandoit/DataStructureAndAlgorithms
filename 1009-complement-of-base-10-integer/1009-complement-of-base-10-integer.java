class Solution {
    public int bitwiseComplement(int n) {
        //original(101)+1'complement(010)=111
        
        int x=1;
        while(x<n){
            x=x*2+1;
        }
        return x-n;
    }
}