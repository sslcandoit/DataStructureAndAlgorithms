class Solution {
    public boolean winnerOfGame(String colors) {
        int a=0, b=0, n=colors.length();
        for(int i=2; i<n; i++){
            char c=colors.charAt(i);
            if(c==colors.charAt(i-1) && colors.charAt(i-1)==colors.charAt(i-2)){
                if(c=='A') a++;
                else b++;
            }     
        }
        return a>b;
    }
}