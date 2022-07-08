class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set=new HashSet<>(Arrays.asList(words));
        
        for(String w:words){
            for(int i=1; i<w.length(); i++){
                String sub=w.substring(i);
                set.remove(sub);
            }
        }
        int ans=0;
        for(String s:set){
            ans+=s.length()+1;
        }
        return ans;
    }
}