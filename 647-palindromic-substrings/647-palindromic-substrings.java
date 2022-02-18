class Solution {
    public int countSubstrings(String s) {
        int len=s.length();
        int ans=0;
        for(int i=0; i<len; i++){
            for(int j=0; i-j>=0 && i+j<len && (s.charAt(i-j)==s.charAt(i+j)); j++) ans++;
            for(int j=0; i-j>=0 && i+1+j<len && (s.charAt(i-j)==s.charAt(i+1+j)); j++) ans++;
        }
        return ans;
    }
        /*
        int ans=0;
        for(int i=0; i<s.length(); i++){
            ans+=checkPalindromic(s, i, i);
            ans+=checkPalindromic(s, i, i+1);
        }
        return ans;
    }
    private int checkPalindromic(String s, int l, int r){
        int count=0;
        while(l>=0 && r<s.length()){
            if(s.charAt(l) !=s.charAt(r)) break;
            count++;
            l--;
            r++;
        }
        return count;
    }
    */
}