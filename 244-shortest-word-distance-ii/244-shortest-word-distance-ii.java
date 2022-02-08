class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        this.map=new HashMap<>();
        for(int i=0; i<wordsDict.length; i++){
            String str=wordsDict[i];
            if(!map.containsKey(str)) map.put(str, new ArrayList<>());
            map.get(str).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1=map.get(word1);
        List<Integer> l2=map.get(word2);
        int min=Integer.MAX_VALUE;
        for(int index1:l1){
            for(int index2:l2){
                min=Math.min(min, Math.abs(index1-index2));
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */