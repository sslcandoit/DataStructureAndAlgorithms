class Solution {
    public int longestStrChain(String[] words) {
        int ans=0;
        Map<String, Integer> dp=new HashMap<>();
        Arrays.sort(words, (o1, o2)-> o1.length()-o2.length());
        
        for(int i=0; i<words.length; i++){
            String w=words[i];
            
            int best=0;
            for(int j=0; j<w.length(); j++){
                String sub=w.substring(0,j)+w.substring(j+1);
                best=Math.max(best, dp.getOrDefault(sub, 0)+1);
            }
            dp.put(w, best);
            ans=Math.max(ans, best);
        }
        return ans;
    }
}