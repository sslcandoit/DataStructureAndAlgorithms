class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<StringBuilder>[] home=new List[26];
        
        for(int i=0; i<26; i++) home[i]=new ArrayList<>();
        
        for(String w:words){
            home[w.charAt(0)-'a'].add(new StringBuilder(w));
        }
        
        int len=s.length(), ans=0;
        for(int i=0; i<len; i++){
            List<StringBuilder> temp=home[s.charAt(i)-'a'];
            
            home[s.charAt(i)-'a']=new ArrayList<>();
            
            for(StringBuilder sb:temp){
                sb.deleteCharAt(0);
                
                if(sb.length()==0) ans++;
                else home[sb.charAt(0)-'a'].add(new StringBuilder(sb));
            }
        }  
        return ans;
    }
}