class Solution {
    public int minSwaps(String s) {
        int one=0, zero=0;
        
        for(char c:s.toCharArray()){
            if(c=='1') one++;
            else zero++;
        }
        
        if(Math.abs(one-zero)>1) return -1;
        
        if(one>zero) return helper(s, '1');
        else if(zero>one) return helper(s, '0');
        return Math.min(helper(s, '1'), helper(s, '0'));
    }
    private int helper(String s, char c){
        int swap=0;
        
        for(char ch:s.toCharArray()){
            if(ch !=c) swap++;
            c^=1;
        }
        return swap/2;
    }
}