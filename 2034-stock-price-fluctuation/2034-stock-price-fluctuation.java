class StockPrice {
    TreeMap<Integer, Integer> record=new TreeMap<>();
    TreeMap<Integer, Set<Integer>> prices=new TreeMap<>();
    public StockPrice() {
        
    }
    
    public void update(int timestamp, int price) {
        if(!record.containsKey(timestamp)){
            record.put(timestamp, price);
        }else{
            int oldPrice=record.get(timestamp);
            record.put(timestamp, price);
            
            prices.get(oldPrice).remove(timestamp);
            if(prices.get(oldPrice).size()==0) prices.remove(oldPrice);
        }
        if(!prices.containsKey(price)) prices.put(price, new HashSet<>());
        prices.get(price).add(timestamp);
    }
    
    public int current() {
        return record.lastEntry().getValue();
    }
    
    public int maximum() {
        return prices.lastKey();
    }
    
    public int minimum() {
        return prices.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */