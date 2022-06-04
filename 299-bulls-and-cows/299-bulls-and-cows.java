class Solution {
    public String getHint(String secret, String guess) {
        int[] count=new int[10];
        int countA=0, countB=0;
        
        int len=secret.length();
        for(int i=0; i<len; i++) count[secret.charAt(i)-'0']++;
        
        for(int i=0; i<len; i++){
            if(secret.charAt(i)==guess.charAt(i)){
                countA++;
                count[guess.charAt(i)-'0']--;
            }
        }
        for(int i=0; i<len; i++){
            if(secret.charAt(i) !=guess.charAt(i) && count[guess.charAt(i)-'0']>0){
                countB++;
                count[guess.charAt(i)-'0']--;
            } 
        }
        return countA+"A"+countB+"B";
    }
}