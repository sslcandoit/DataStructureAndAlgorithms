class FileSystem {
    Map<String, Integer> map;
    public FileSystem() {
        this.map=new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        String[] str=path.split("/");
        int len=str.length;
     
        String temp="";
        for(int i=1; i<len-1; i++){
            temp=temp+("/"+str[i]);
        }
        String key=temp+"/"+str[len-1];
        if((temp.length()==0 || map.containsKey(temp)) && !map.containsKey(key)){
            map.put(key, value);
            return true;
        }
        return false;
    }
    
    public int get(String path) {
        if(!map.containsKey(path)) return -1;
        return map.get(path);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */