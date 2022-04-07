class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map=new HashMap<>();
        for(String str:strings){
            String key=getKey(str);
            List<String> list=map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
    private String getKey(String str){
        String key="";
        for(int i=1; i<str.length(); i++){
            int distance=str.charAt(i)-str.charAt(i-1);
            if(distance<0) distance+=26;
            key+=distance+"/";
        }
        return key;
    }
}