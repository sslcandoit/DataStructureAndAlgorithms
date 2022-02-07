class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map=new HashMap<>();
        for(int i=0; i<names.length; i++){
            names[i]=getName(map, names[i]);
        }
        return names;
    }
    private String getName(Map<String, Integer> map, String name){
        if(!map.containsKey(name)) map.put(name, 0);
        else{
            int n=map.get(name)+1;
            while(map.containsKey(name+"("+n+")")) n++;
            
            map.put(name, n);
            return getName(map, name+"("+n+")");
        }
        return name;
    }
}