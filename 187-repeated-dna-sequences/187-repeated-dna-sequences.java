class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map=new HashMap<>();
        int m=s.length();
        for(int i=10; i<=m; i++){
            String sub=s.substring(i-10, i);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        List<String> ans=new ArrayList<>();
        
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue()>1) ans.add(e.getKey());
        }
        return ans;
    }
}