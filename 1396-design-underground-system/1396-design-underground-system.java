class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkIn;
    private Map<String, Pair<Double, Integer>> total;
    public UndergroundSystem() {
        this.checkIn=new HashMap<>();
        this.total=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        this.checkIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> p=checkIn.get(id);
        String in=p.getKey();
        int start=p.getValue();
        
        String station=in+"-"+stationName;
        int time=t-start;
        
        if(!total.containsKey(station)) total.put(station, new Pair<>(time/1.0, 1));
        else {
            double sum=total.get(station).getKey()+(double)time;
            int count=total.get(station).getValue()+1;
            total.put(station, new Pair<>(sum, count));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> p=total.get(startStation+"-"+endStation);
        return p.getKey()/p.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */