class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> connect=new HashMap<>();
        for(List<String> pair:synonyms){
            String s1=pair.get(0), s2=pair.get(1);
            connect.putIfAbsent(s1, new ArrayList<>());
            connect.get(s1).add(s2);
            
            connect.putIfAbsent(s2, new ArrayList<>());
            connect.get(s2).add(s1);
        }
        
        Set<String> ans=new TreeSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(text);
        
        while(!q.isEmpty()){
            String cur=q.poll();
            ans.add(cur);
            String[] sentence=cur.split(" ");
            
            for(int i=0; i<sentence.length; i++){
                if(!connect.containsKey(sentence[i])) continue;
                
                for(String word:connect.get(sentence[i])){
                    sentence[i]=word;
                    String newStr=String.join(" ", sentence);
                    if(!ans.contains(newStr)) q.add(newStr);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}