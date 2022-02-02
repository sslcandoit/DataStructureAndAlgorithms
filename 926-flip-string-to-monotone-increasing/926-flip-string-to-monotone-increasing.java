class Solution {
    public int minFlipsMonoIncr(String s) {
        int flip=0;
        int one=0;
        for(char c:s.toCharArray()){
            if(c=='0' && one !=0) flip++;
            else if(c=='1') one++;
            
            if(flip>one) flip=one;
        }
        return flip;
    }
}