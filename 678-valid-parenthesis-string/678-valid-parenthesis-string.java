class Solution {
    public boolean checkValidString(String s) {
        char[] chars=s.toCharArray();
        
        int leftWild=0;
        for(char c:chars){
            if(c==')'){
                if(leftWild==0) return false;
                leftWild--;
            }else leftWild++;
        }
        
        int left=0;
        for(char c:chars){
            if(c=='(') left++;
            else left=Math.max(0, left-1);
        }
        return left==0;
        /*
        char[] chars=s.toCharArray();
        int leftWild=0;
        int left=0;
        
        for(char c:chars){
            leftWild+=(c==')'? -1: +1);
            if(leftWild<0) return false;
            
            left+=(c=='('? +1: -1);
            left=Math.max(0, left);
        }
        return left==0;*/
    }
}