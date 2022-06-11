class OrderedStream {
    String[] record;
    int curID;
    public OrderedStream(int n) {
        this.record=new String[n+1];
        this.curID=1;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> list=new ArrayList<>();
        
        if(idKey !=this.curID){
            this.record[idKey]=value;
            return list;
        } 
        list.add(value);
        this.curID++;
        while(this.curID<this.record.length && this.record[this.curID] !=null){
            list.add(this.record[this.curID]);
            this.curID++;
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */