class Solution {
    public char findTheDifference(String s, String t) {
        int[] count=new int[26];
        int m=s.length();
        for(int i=0; i<m+1; i++){
            if(i<m) count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        int i;
        for(i=0; i<26; i++){
            if(count[i]<0) break;
        }
        return (char)(i+'a');
    }
}