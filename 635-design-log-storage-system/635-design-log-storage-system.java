class LogSystem {
    Map<String, Integer> map;
    TreeMap<String, List<Integer>> record;
    public LogSystem() {
        this.map=new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        this.record=new TreeMap<>();
    }
    
    public void put(int id, String timestamp) {
        this.record.putIfAbsent(timestamp, new ArrayList<>());
        record.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        String min="2000:01:01:00:00:00", max="2017:12:31:23:59:59";
        int index=this.map.get(granularity);
        
        String s=start.substring(0, index)+min.substring(index);
        String e=end.substring(0, index)+max.substring(index);
        Map<String, List<Integer>> sub=this.record.subMap(s, true, e, true);
        
        List<Integer> ans=new ArrayList<>();
        for(List<Integer> list:sub.values()){
            ans.addAll(list);
        }
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */