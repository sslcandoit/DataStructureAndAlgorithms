class Solution {
    public String getHint(String secret, String guess) {
        int[] count=new int[10];
        int bulls=0, cows=0;
        
        int len=secret.length();
        for(int i=0; i<len; i++){
            char c1=secret.charAt(i);
            char c2=guess.charAt(i);
            
            if(c1==c2) bulls++;
            else{
                if(count[c1-'0']++ <0) cows++;
                if(count[c2-'0']-- >0) cows++;
            }
        }
        return bulls+"A"+cows+"B";
    }
}