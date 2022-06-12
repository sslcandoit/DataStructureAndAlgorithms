class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count=new int[26];
        for(int i=0; i<chars.length(); i++) count[chars.charAt(i)-'a']++;
        
        int ans=0;
        for(String w:words){
            int[] cnt=count.clone();
            int m=w.length(), i;
            for(i=0; i<m; i++){
                if(--cnt[w.charAt(i)-'a']<0) break;
            }
            if(i==m) ans+=m;
        }
        return ans;
    }
}