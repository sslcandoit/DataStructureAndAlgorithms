class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count=new int[26], temp;
        
        for(String w2:words2){
            temp=counter(w2);
            
            for(int i=0; i<26; i++){
                count[i]=Math.max(count[i], temp[i]);
            }
        }
        
        List<String> ans=new ArrayList<>();
        
        for(String w1:words1){
            temp=counter(w1);
            
            int i;
            for(i=0; i<26; i++){
                if(temp[i]<count[i]) break;
            }
            
            if(i==26) ans.add(w1);
        }
        
        return ans;
    }
    private int[] counter(String s){
        int[] ans=new int[26];
        
        for(char c:s.toCharArray()){
            ans[c-'a']++;
        }
        return ans;
    }
}