class TimeMap {
    class Node{
        int timestamp;
        String value;
        public Node(int time, String v){
            this.timestamp=time;
            this.value=v;
        }
    }
    Map<String, List<Node>> map;
    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Node> list=map.get(key);
        int len=list.size();
        if(len==1 && list.get(0).timestamp<=timestamp) return list.get(0).value;
        
        int l=0;
        int r=list.size();
        while(l<r){
            int m=l+(r-l)/2;
            if(list.get(m).timestamp>timestamp) r=m;
            else l=m+1;
        }
        if(l==0 && list.get(l).timestamp<=timestamp) return list.get(l).value; 
        else if(l==0 && list.get(l).timestamp>timestamp) return "";
        else if(list.get(l-1).timestamp<=timestamp) return list.get(l-1).value;
        return "";
    }
    /*
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap<Integer, String> temp=map.get(key);
        Integer floor=temp.floorKey(timestamp);
        if(floor==null) return "";
        return temp.get(floor);
    }
    */
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */