class Solution {
    public int minCharacters(String a, String b) {
        int[] countA=new int[26], countB=new int[26];
        int ans=Integer.MAX_VALUE, m=a.length(), n=b.length();
        
        for(int i=0; i<m; i++) countA[a.charAt(i)-'a']++;
        for(int i=0; i<n; i++) countB[b.charAt(i)-'a']++;
        
        for(int i=0; i<26; i++){
            ans=Math.min(ans, m+n-countA[i]-countB[i]);
            
            if(i>0){
                countA[i]+=countA[i-1];
                countB[i]+=countB[i-1];
            }
            if(i<25){
                ans=Math.min(ans, m-countA[i]+countB[i]);
                ans=Math.min(ans, n-countB[i]+countA[i]);
            }
        }
        return ans;
    }
}