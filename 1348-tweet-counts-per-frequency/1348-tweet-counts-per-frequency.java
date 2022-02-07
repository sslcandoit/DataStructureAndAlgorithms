class TweetCounts {
    private Map<String, TreeMap<Integer, Integer>> map;
    public TweetCounts() {
        this.map=new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.putIfAbsent(tweetName, new TreeMap<>());
        Map<Integer, Integer> temp=map.get(tweetName);
        temp.put(time, temp.getOrDefault(time, 0)+1);//in case more tweet in same time
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> ans=new ArrayList<>();
        if(!map.containsKey(tweetName)) return ans;
        
        TreeMap<Integer, Integer> temp=map.get(tweetName);
        
        int gap=60;
        if(freq.equals("hour")) gap=3600;
        else if(freq.equals("day")) gap=86400;
        
        for(int start=startTime; start<=endTime; start+=gap){
            int end=Math.min(endTime+1, start+gap);
            
            Map<Integer, Integer> subMap=temp.subMap(start, end);
            int count=0;
            for(int v: subMap.values()){
                count+=v;
            }
            ans.add(count);
        }
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */