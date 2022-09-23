class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new ArrayList<>();
        if(pattern.length()==1){
            for(String w:words) ans.add(w);
            return ans;
        };
        
        Map<Character, Integer> map=new HashMap<>();
        
        for(int i=0; i<pattern.length(); i++){
            char c=pattern.charAt(i);
            if(!map.containsKey(c)) map.put(c, i);
        }
        
        
        
        for(String w:words){
            Map<Character, Integer> temp=new HashMap<>();
            temp.put(w.charAt(0), 0);
            
            int i;
            for(i=1; i<w.length(); i++){
                char c=w.charAt(i);
                
                if(!temp.containsKey(c)) temp.put(c, i);
                
                if(  (c == w.charAt(i-1) && pattern.charAt(i) != pattern.charAt(i-1) )
                  || (c != w.charAt(i-1) && pattern.charAt(i) == pattern.charAt(i-1) )
                  || (map.get(pattern.charAt(i)) != temp.get(c)) ) break;
            }
            if(i==w.length()) ans.add(w);
        }
        return ans;
    }
}