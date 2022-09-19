class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        
        for(int i=2; i<=len; i++){
            
            if(len%i==0){
                
                int span=len/i;
                String sub=s.substring(0, span);
                
                String guess=sub.repeat(i);
                
                if(guess.equals(s)) return true;
            }
        }
        return false;
    }
}