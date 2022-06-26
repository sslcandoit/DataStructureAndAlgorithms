class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count=new int[26];
        int m=s.length();
        for(int i=0; i<m; i++){
            count[s.charAt(i)-'a']++;
        }
        int countPair=0;
        for(int i=0; i<26; i++){
            if(count[i]>1) countPair+=count[i]/2;
        }
        if((m%2==0 && countPair*2==m) || (m%2==1 && countPair*2+1==m)) return true;
        return false;
    }
}