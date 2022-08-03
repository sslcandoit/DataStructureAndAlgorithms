class Solution {
    public int longestSubstring(String s, int k) {
        int len=s.length();
        
        int[] count=new int[26];
        for(int i=0; i<len; i++){
            count[s.charAt(i)-'a']++;
        }
        
        boolean allValid=true;
        for(int i=0; i<len; i++){
            int index=s.charAt(i)-'a';
            if(count[index]>0 && count[index]<k) allValid=false;
        }
        if(allValid) return len;
        
        int beg=0, end=0, ans=0;
        while(end<len){
            if(count[s.charAt(end)-'a']<k){
                ans=Math.max(ans, longestSubstring(s.substring(beg, end), k));
                beg=end+1;
            }
            end++;
        }
        
        ans=Math.max(ans, longestSubstring(s.substring(beg), k));
        return ans;
    }
}