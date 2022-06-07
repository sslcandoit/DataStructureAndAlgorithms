class Solution {
    public String baseNeg2(int n) {
        String s="";
        while(n !=0){
            s=(n&1)+s;
            n=-(n>>1);
        }
        return s.length()>0? s:"0";
    }
    private String base2(int n){
        String s="";
        while(n !=0){
            s=(n&1)+s;
            n=n>>1;
        }
        return s.length()>0? s:"0";
    }
}
/*
5/2=2;
-5/-2=2
-5/2=-2
5/-2=-2
*/