class Solution {
    public int characterReplacement(String s, int k) {
        int len=s.length();
        if(len<2) return len;
        
        int[] count=new int[26];
        
        int l=0, r=0, maxFreq=0;
        while(r<len){
            count[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, count[s.charAt(r)-'A']);
            r++;
            
            if(maxFreq+k<r-l){
                count[s.charAt(l)-'A']--;
                l++;
            }
        }
        return r-l;
    }
}