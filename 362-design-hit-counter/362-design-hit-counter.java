class HitCounter {
    Deque<Pair<Integer, Integer>> q;//store timeStamp and freq
    int count;
    public HitCounter() {
        this.q=new ArrayDeque<>();
        this.count=0;
    }
    
    public void hit(int timestamp) {
        if(q.size()>0 && q.peekLast().getKey()==timestamp){
            Pair<Integer, Integer> temp=q.pollLast();
            q.offerLast(new Pair<>(timestamp, temp.getValue()+1));
        }else{
            q.offerLast(new Pair<>(timestamp, 1));
        }
        count++;
    }
    
    public int getHits(int timestamp) {
        if(timestamp<=300) return count;
        int extra=timestamp-300;
        while(q.size()>0 && q.peekFirst().getKey()<=extra){
            Pair<Integer, Integer> temp=q.pollFirst();
            count-=temp.getValue();
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */